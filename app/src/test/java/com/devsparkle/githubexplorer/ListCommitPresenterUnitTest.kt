package com.devsparkle.githubexplorer

import com.devsparkle.githubexplorer.domain.interactor.GithubInteractor
import com.devsparkle.githubexplorer.domain.model.CommitDTO
import com.devsparkle.githubexplorer.domain.repository.ICommitRemoteRepository
import com.devsparkle.githubexplorer.presentation.screen.displayCommits.ListCommitContract
import com.devsparkle.githubexplorer.presentation.screen.displayCommits.ListCommitPresenter
import io.reactivex.Single
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.observers.TestObserver
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(MockitoJUnitRunner::class)
class ListCommitPresenterUnitTest {

    @Mock
    private lateinit var mockMainActivity: ListCommitContract.View


    @Mock
    private lateinit var gitRemoteRepository: ICommitRemoteRepository


    internal lateinit var underTest: GithubInteractor

    private var presenter: ListCommitPresenter? = null

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        underTest = GithubInteractor(gitRemoteRepository)
        presenter = ListCommitPresenter(mockMainActivity, underTest)

        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }

    }

    @After
    fun tearDown() {

    }

    @Test
    fun `when commitss are requested, should call client and return response`() {


        val commitDto = CommitDTO(
            authorName = "My Author Name",
            authorImage = "https://avatars1.githubusercontent.com/u/908958?s=400&v=4",
            timeAndDate = Date().toString(),
            authorEmail = "myauthoremail@france.com",
            title = "My Commit Message"
        )


        val commitDto2 = CommitDTO(
            authorName = "My Author Name2",
            authorImage = "https://avatars1.githubusercontent.com/u/908958?s=400&v=4",
            timeAndDate = Date().toString(),
            authorEmail = "myauthoremail2@france.com",
            title = "My Commit Message2"
        )

        val commitDto3 = CommitDTO(
            authorName = "My Author Name3",
            authorImage = "https://avatars1.githubusercontent.com/u/908958?s=400&v=4",
            timeAndDate = Date().toString(),
            authorEmail = "myauthoremail3@france.com",
            title = "My Commit Message3"
        )


        val list = mutableListOf<CommitDTO>()
        list.add(commitDto)
        list.add(commitDto2)
        list.add(commitDto3)

        Mockito.`when`(gitRemoteRepository.fetchCommits("JetBrains", "kotlin"))
            .thenReturn(Single.just(list))

        val result = underTest.getCommitsByUserAndRepo("JetBrains", "kotlin")

        val testObserver = TestObserver<List<CommitDTO>>()
        result.subscribe(testObserver)
        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)
        val listResult = testObserver.values()[0]
        assertEquals(listResult.size, (3))
        assertEquals(listResult[0].title, "My Commit Message")
        assertEquals(listResult[0].authorName, "My Author Name")
        assertEquals(listResult[0].authorEmail, "myauthoremail@france.com")
        assertEquals(listResult[1].title, "My Commit Message2")
        assertEquals(listResult[1].authorName, "My Author Name2")
        assertEquals(listResult[1].authorEmail, "myauthoremail2@france.com")
    }


    @Test
    fun testOnViewCreatedFlow() {
        presenter!!.getCommitList("JetBrains", "kotlin")
        //  Mockito.any<CommitDTO>(mockMainActivity).
        //  Mockito.verify(mockMainActivity).showCommitList()
    }
}
