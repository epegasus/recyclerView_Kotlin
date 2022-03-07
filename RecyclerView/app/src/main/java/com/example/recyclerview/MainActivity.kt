package com.example.recyclerview

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview.adapters.CustomAdapterMain
import com.example.recyclerview.data_classes.Student
import com.example.recyclerview.databinding.ActivityMainBinding
import com.example.recyclerview.interfaces.OnItemClick

class MainActivity : AppCompatActivity(), OnItemClick {

    private lateinit var binding: ActivityMainBinding
    private var studentList: ArrayList<Student> = arrayListOf()
    private var adapter: CustomAdapterMain? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadList()
    }

    private fun loadList() {
        studentList.add(Student("Sohaib", 145))
        studentList.add(Student("Student 1", 146))
        studentList.add(Student("Student 2", 147))
        studentList.add(Student("Student 3", 148))
        studentList.add(Student("Student 4", 149))

        loadView()
    }

    private fun loadView() {
        adapter = CustomAdapterMain(studentList, this)
        binding.recyclerViewMain.adapter = adapter
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item Removed", Toast.LENGTH_SHORT).show()
        studentList.removeAt(position)
        adapter?.notifyItemRemoved(position)
        adapter?.notifyItemRangeChanged(position, studentList.size)
    }
}