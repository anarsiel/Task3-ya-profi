package controllers

import data.Participant
import data.Promotion

class MainController {
    private val promotions = mutableMapOf<Int, Promotion>()

    fun postPromo(promotion: Promotion) {
        promotion.id = promotions.size
        promotions[promotions.size] = promotion
    }

    fun getPromo(): MutableMap<Int, Promotion> {
        return promotions
    }

    fun getPromoById(id: String?): Promotion {
        return promotions[id!!.toInt()]!!
    }

    fun putPromo(id: String?, promotion: Promotion) {
        val idInt = id!!.toInt()

        if (promotion.name != null)
            promotions[idInt]!!.name = promotion.name

        promotions[idInt]!!.description = promotion.description
    }

    fun deletePromoById(id: String?) {
        promotions.remove(id!!.toInt())
    }

    fun addParticipantToPromo(id: String?, participant: Participant) {
        val idInt = id!!.toInt()

        promotions[idInt]!!.participants!!.add(participant)
    }
}