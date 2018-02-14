package pragmatico

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class ProjectsInterceptor implements InterceptorBase {
  boolean before() {
    Account account = getAccountFromRequest(request)
    if (account) {
      request.setAttribute('currentUser', account)
      return true
    }

    response.sendError(401)
    false
  }
}
