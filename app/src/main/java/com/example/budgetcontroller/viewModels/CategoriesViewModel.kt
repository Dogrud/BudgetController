package com.example.budgetcontroller.viewModels

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.budgetcontroller.models.Category
import com.example.budgetcontroller.ui.theme.Primary
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


data class CategoriesState(
    val newCategoryColor: Color = Color.White,
    val newCategoryName: String = "",
    val colorPickerShowing: Boolean = false,
    val categories: MutableList<Category> = mutableListOf(
        Category("Bills",Color.Red),
        Category("Shopping",Color.Blue),
        Category("Concert",Color.White),
        Category("deneme",Color.Red),
        Category("deneme3",Color.Blue),
        Category("deneme6",Color.White),

    )


)


class CategoriesViewModel : ViewModel() {
 private  val _uiState = MutableStateFlow(CategoriesState())
 val uiState: StateFlow<CategoriesState> = _uiState.asStateFlow()

    fun setNewCategoryColor(color: Color){
        _uiState.update { currenState ->
            currenState.copy(
                newCategoryColor =  color
            )
        }
    }

    fun setNewCategoryName(name: String){
        _uiState.update { currenState ->
            currenState.copy(
                newCategoryName = name
            )
        }
    }

    fun showColorPicker(){  
        _uiState.update { currentState ->
            currentState.copy(
                colorPickerShowing = true
            )
        }
    }

    fun hideColorPicker(){
        _uiState.update { currentState ->
            currentState.copy(
                colorPickerShowing = false
            )
        }

    }


   fun createNewCategory(){
       // TODO save new category to local db
       val newList = mutableListOf(
           Category(
              _uiState.value.newCategoryName,
               _uiState.value.newCategoryColor
           )
       )

       newList.addAll(
           _uiState.value.categories
       )

       _uiState.update {
           currentState->
           currentState.copy(
               categories = newList,
               newCategoryColor = Color.White,
               newCategoryName = ""
           )
       }

   }

    fun DeleteCategory(category: Category){
        val index = _uiState.value.categories.indexOf(category)
        val newList = mutableListOf<Category>()
        newList.addAll(_uiState.value.categories)
        newList.removeAt(index)

        _uiState.update { currentState ->
            currentState.copy(
                categories = newList
            )
        }
    }



}