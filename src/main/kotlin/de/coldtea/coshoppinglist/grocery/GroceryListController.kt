package de.coldtea.coshoppinglist.grocery

import de.coldtea.coshoppinglist.grocery.exception.GroceryItemNotFound
import de.coldtea.coshoppinglist.grocery.model.GroceryItem
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
class GroceryListController {

    val groceryItems = mutableListOf<GroceryItem>()

    @GetMapping("/glist")
    fun getGroceryList(@RequestParam(name = "quantity_type", required = false) quantityType: Int?) =
        if (quantityType != null) groceryItems.filter { it.quantityType == quantityType } else groceryItems

    @GetMapping("/glist/{id}")
    fun getNFTById(@PathVariable id: String) : GroceryItem? {
        return groceryItems.firstOrNull { it.id == id } ?: throw GroceryItemNotFound()
    }

    @PostMapping(value = ["/glist"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    fun postGroceryItem(@RequestBody groceryItem: GroceryItem){
        val newGroceryItem = GroceryItem(
            UUID.randomUUID().toString(),
            groceryItem.name,
            groceryItem.brand,
            groceryItem.quantity,
            groceryItem.quantityType,
            groceryItem.note,
            groceryItem.isCrossedOut
        )

        groceryItems.add(newGroceryItem)
    }
}