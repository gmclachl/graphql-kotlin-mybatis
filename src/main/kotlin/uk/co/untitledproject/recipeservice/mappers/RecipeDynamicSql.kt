package uk.co.untitledproject.recipeservice.mappers

import org.mybatis.dynamic.sql.SqlTable
import java.sql.JDBCType

class RecipeDynamicSql {

    object DynamicSqlSupport {
        object RecipeDAO : SqlTable("recipe") {
           val id = column<Int>("id", JDBCType.INTEGER)
           val recipe_name = column<String>("recipe_name", JDBCType.VARCHAR)
        }
    }
}