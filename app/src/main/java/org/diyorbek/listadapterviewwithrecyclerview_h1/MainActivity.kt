package org.diyorbek.listadapterviewwithrecyclerview_h1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.GridLayoutManager
import org.diyorbek.listadapterviewwithrecyclerview_h1.adapter.GameAdapter
import org.diyorbek.listadapterviewwithrecyclerview_h1.databinding.ActivityMainBinding

import org.diyorbek.listadapterviewwithrecyclerview_h1.util.Constants

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val gamesAdapter by lazy { GameAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = gamesAdapter
        }
        gamesAdapter.submitList(Constants.list)
        gamesAdapter.onClick = {
            val bundle = bundleOf("games" to it)
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}