package com.example.cupcake.ui.order

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor() : ViewModel() {

    private val PRICE_PER_CUPCAKE = 2.00
    private val PRICE_FOR_SAME_DAY_PICKUP = 3.00

    private val _uiState = MutableStateFlow(OrderUiState(pickupOptions = pickupOptions()))
    val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()

    private fun pickupOptions(): List<String> {
        val dateOptions = mutableListOf<String>()
        val formatter = SimpleDateFormat("EEEE,MMMM D,YYYY", Locale.getDefault())
        val calendar = Calendar.getInstance()
        repeat(4) {
            dateOptions.add(formatter.format(calendar.time))
            //Advances the calendar by 1 day.
            calendar.add(Calendar.DATE, 1)
        }
        return dateOptions
    }

    fun setFlavor(desiredFlavor: String) {
        _uiState.update { currentState ->
            currentState.copy(
                flavor = desiredFlavor
            )
        }
    }

    fun setDate(pickupDate: String) {
        _uiState.update { currentState ->
            currentState.copy(
                date = pickupDate,
                price = calculatePrice(pickupDate = pickupDate)
            )
        }
    }

    fun setQuantity(numberCupcakes: Int) {
        _uiState.update { currentState ->
            currentState.copy(
                quantity = numberCupcakes,
                price = calculatePrice(quantity = numberCupcakes)
            )
        }
    }

    fun resetOrder() {
        _uiState.value = OrderUiState(pickupOptions = pickupOptions())
    }


    private fun calculatePrice(
        quantity: Int = _uiState.value.quantity,
        pickupDate: String = _uiState.value.date
    ): String {
        var calculatedPrice = quantity * PRICE_PER_CUPCAKE
        if (pickupOptions()[0] == pickupDate) {
            calculatedPrice += PRICE_FOR_SAME_DAY_PICKUP
        }
        val formattedPrice = NumberFormat.getCurrencyInstance().format(calculatedPrice)
        return formattedPrice
    }
}