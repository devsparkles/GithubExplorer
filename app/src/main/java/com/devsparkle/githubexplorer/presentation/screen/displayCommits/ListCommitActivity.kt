package com.devsparkle.githubexplorer.presentation.screen.displayCommits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.devsparkle.githubexplorer.R
import dagger.android.AndroidInjection

class ListCommitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_commit)
    }
}
