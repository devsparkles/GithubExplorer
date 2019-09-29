package com.devsparkle.githubexplorer.presentation.screen.displayCommits

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.devsparkle.githubexplorer.R
import com.devsparkle.githubexplorer.domain.model.CommitDTO
import com.devsparkle.githubexplorer.presentation.adapter.ListAdapter
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_list_commit.*
import javax.inject.Inject

class ListCommitActivity : DaggerAppCompatActivity(), ListCommitContract.View {

    @Inject
    lateinit var presenter:ListCommitPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_commit)
    }

    override fun onResume() {
        super.onResume()
        presenter.getCommitList("JetBrains", "Kotlin")
    }

    override fun showCommitList(list: List<CommitDTO>) {
        var adapter = ListAdapter(
            this,
            list.toMutableList()
        )
        commitList!!.setLayoutManager(LinearLayoutManager(this))
        commitList!!.setAdapter(adapter)
    }


}
