package de.coldtea.coshoppinglist.grocery

import com.fasterxml.jackson.databind.ObjectMapper
import de.coldtea.coshoppinglist.grocery.model.GroceryItem
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post

@SpringBootTest
@AutoConfigureMockMvc
class GroceryListControllerTest(
    @Autowired val mockMvc: MockMvc,
    @Autowired val objectMapper: ObjectMapper
) {

    @Test
    fun `new grocery item is created with a UUID`() {

        val item = GroceryItem(
            null,
            "bread",
            "edeka",
            1,
            0,
            "note",
            false
        )

        mockMvc.post("/glist") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(item)
        }.andExpect {
            status { isCreated() }

            mockMvc.get("/glist", 0)
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$.[0].id") { isNotEmpty() }
                    jsonPath("$.[0].name") { value("bread") }
                    jsonPath("$.[0].brand") { value("edeka") }
                    jsonPath("$.[0].quantity") { value(1) }
                    jsonPath("$.[0].quantity_type") { value(0) }
                    jsonPath("$.[0].note") { value("note") }
                    jsonPath("$.[0].is_crossed_out") { value("false") }
                }
        }
    }
}