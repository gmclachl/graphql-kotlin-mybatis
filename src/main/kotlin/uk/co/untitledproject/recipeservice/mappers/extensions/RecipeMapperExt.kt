package uk.co.untitledproject.recipeservice.mappers.extensions

import org.mybatis.dynamic.sql.util.kotlin.SelectCompleter
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectList
import uk.co.untitledproject.recipeservice.mappers.RecipeDynamicSql.DynamicSqlSupport.RecipeDAO
import uk.co.untitledproject.recipeservice.mappers.RecipeDynamicSql.DynamicSqlSupport.RecipeDAO.id
import uk.co.untitledproject.recipeservice.mappers.RecipeDynamicSql.DynamicSqlSupport.RecipeDAO.recipe_name

import uk.co.untitledproject.recipeservice.mappers.RecipeMapper

private val columnList = listOf(id, recipe_name)

fun RecipeMapper.select(completer: SelectCompleter) =
        selectList(this::selectMany, columnList, RecipeDAO, completer )