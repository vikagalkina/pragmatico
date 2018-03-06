package pragmatico

import grails.compiler.GrailsCompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.bson.types.ObjectId
import pragmatico.fields.project.ProjectProperties
import pragmatico.fields.project.embedds.Status

@GrailsCompileStatic
@EqualsAndHashCode(includes = 'id')
@ToString(includes = 'id', includeNames = true, includePackage = false)
class Project extends ProjectProperties implements Serializable {
  ObjectId id
  Date dateCreated
  Date lastUpdated
  Status status = Status.APPROVED // TODO change it to PENDING once admin part is ready
  Float rating
  Date ratingUpdatedAt

  static embedded = ['categories', 'steps', 'periods', 'founders', 'advisors']

  static belongsTo = [account: Account]

  static constraints = {
    twitterlink blank: true, nullable: true
    bitcoinlink blank: true, nullable: true
    telegramlink blank: true, nullable: true
    fblink blank: true, nullable: true
    youtube blank: true, nullable: true
    rating bindable: false, nullable: true
    status bindable: false
  }

  static mapping = {
    collection 'projects'
    account attr: 'accountId', index: true
    status defaultValue: Status.PENDING, enumType: 'string', index: true
    dateCreated index: true
    lastUpdated index: true
    rating index: true
    fblink index: true
    twitterlink index: true
    bitcoinlink index: true
  }
}
