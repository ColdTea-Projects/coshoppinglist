package de.coldtea.coshoppinglist.grocery.model

import com.fasterxml.jackson.annotation.JsonProperty

data class GroceryItem(
    var id: String?,
    @JsonProperty("name")
    var name: String?,
    @JsonProperty("brand")
    var brand: String?,
    @JsonProperty("quantity")
    var quantity: Int?,
    @JsonProperty("quantity_type")
    var quantityType: Int?,//0 Unit, 1 grams, 2 liters, 3 pack
    @JsonProperty("note")
    var note: String?,
    @JsonProperty("is_crossed_out")
    var isCrossedOut: Boolean?
)
