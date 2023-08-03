package com.example.notetakingapp

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.notetakingapp.data.Note
import com.example.notetakingapp.data.NoteViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale


class AddFragment : Fragment() {
    private lateinit var noteViewModel: NoteViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add, container, false)
        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        val btn = view.findViewById<Button>(R.id.add_btn)
        btn.setOnClickListener{
            insertNoteToDB(view)
        }

        return view
    }

    private fun checkPassed(title: String, content: String): Boolean {
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(content))
    }

    private fun insertNoteToDB(view: View) {
        val editTextTitle = view.findViewById<EditText>(R.id.addTitle)
        val editTextContent = view.findViewById<EditText>(R.id.addContent);
        val title = editTextTitle.text.toString()
        val content = editTextContent.text.toString()

        if(checkPassed(title, content)) {
            val formatter = SimpleDateFormat("MM.dd.yyyy", Locale.getDefault())
            val date = Calendar.getInstance().time
            val formattedDate = formatter.format(date)

            val note = Note(0,title, formattedDate, content)
            noteViewModel.addNote(note)
            Toast.makeText(requireContext(), "Note added!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "All fields must be completed!", Toast.LENGTH_LONG).show()
        }
    }

}
