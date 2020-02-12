package uk.co.untitledproject.recipeservice.mappers

import org.apache.ibatis.annotations.*
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter
import org.springframework.stereotype.Component
import uk.co.untitledproject.recipeservice.repositories.RecipeRepository

@Mapper
@Component
interface RecipeMapper {

    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @Results(
            id = "RecipeRecord", value = [
        Result(column = "id", property = "id"),
        Result(column = "recipe_name", property = "name")
    ])
    fun selectMany(selectStatement: SelectStatementProvider) : List<RecipeRepository.Recipe>

    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @ResultMap("RecipeRecord")
    fun selectOne(selectStatement: SelectStatementProvider) : RecipeRepository.Recipe

}