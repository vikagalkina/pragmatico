package pragmatico

import grails.gorm.transactions.Transactional
import org.bson.types.ObjectId
import pragmatico.Account

@Transactional
class ProfileService {

  def update(ObjectId accountId, Map data) {
    SampleJob.triggerNow([args: 'data'])
    def account = Account.findById(accountId)
  }
}
