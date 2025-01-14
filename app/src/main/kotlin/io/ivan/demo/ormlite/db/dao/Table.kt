package io.ivan.demo.ormlite.db.dao

import com.j256.ormlite.dao.Dao
import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable
import io.ivan.demo.ormlite.db.DatabaseHelper

@DatabaseTable(tableName = "table")
data class Table(

        @DatabaseField(generatedId = true)
        var id: Int? = null,

        @DatabaseField
        var category: String = "",

        @DatabaseField
        var content: String = ""
)

class TableDao {

    private val dao = DatabaseHelper.getDao(Table::class.java)

    fun add(table: Table) = dao.createOrUpdate(table)

    fun update(table: Table) = dao.update(table)

    fun delete(table: Table) = dao.delete(table)

    fun queryForAll() = dao.queryForAll()
//    сортировка по какой колонке какой порядок возр убыв
//fun queryForAll() = dao.queryBuilder().orderBy()

    fun removeAll() {
        for (table in queryForAll()) {
            dao.delete(table)
        }
    }

}