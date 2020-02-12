package uk.co.untitledproject.recipeservice.resolvers

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component
import uk.co.untitledproject.recipeservice.filters.RecipeFilter
import uk.co.untitledproject.recipeservice.repositories.RecipeRepository


@Component
class RecipeResolver(private val recipeRepository: RecipeRepository) : GraphQLQueryResolver {

    fun recipes(filter: RecipeFilter?): List<RecipeRepository.Recipe> = recipeRepository.findAll(filter)

}