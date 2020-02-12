package uk.co.untitledproject.recipeservice.repositories


import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
import org.springframework.stereotype.Repository
import uk.co.untitledproject.recipeservice.filters.RecipeFilter
import uk.co.untitledproject.recipeservice.mappers.RecipeDynamicSql.DynamicSqlSupport.RecipeDAO.id
import uk.co.untitledproject.recipeservice.mappers.RecipeDynamicSql.DynamicSqlSupport.RecipeDAO.recipe_name
import uk.co.untitledproject.recipeservice.mappers.RecipeMapper
import uk.co.untitledproject.recipeservice.mappers.extensions.select
import java.util.*

@Repository
class RecipeRepository(private val mapper: RecipeMapper) {

    fun findAll(filter: RecipeFilter?): List<Recipe> {
        return mapper.select {
            where(recipe_name, isEqualTo(filter?.name).`when`(Objects::nonNull) )
                    .and(id, isEqualTo(filter?.id).`when`(Objects::nonNull) )
        }
    }

    data class Recipe(val id: Int? = null,
                      val name: String? = null)
}

