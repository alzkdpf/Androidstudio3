package com.werockstar.dagger2demo.presenter

import com.werockstar.dagger2demo.api.GithubAPI
import com.werockstar.dagger2demo.model.GithubUser
import com.werockstar.dagger2demo.util.RxScheduler
import io.reactivex.Observable
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

@RunWith(JUnit4::class)
class GithubUserPresenterTest {

    private lateinit var presenter: GithubUserPresenter

    @Mock private lateinit var view: GithubUserPresenter.View
    @Mock private lateinit var api: GithubAPI

    @Before
    @Throws(Exception::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        presenter = GithubUserPresenter(api, RxScheduler.rxScheduler)
        presenter.injectView(view)
    }

    @Test
    @Throws(Exception::class)
    fun `get user information should have user data`() {
        val userInfo = GithubUser()

        `when`(api.getUser("WeRockStar")).thenReturn(Observable.just(userInfo))

        presenter.getUserInfo("WeRockStar")

        verify(view).loading()
        verify(view).getUserInfoSuccess(userInfo)
        verify(view).dismissLoading()
        verify(view).hideKeyboard()
    }

    @Test
    @Throws(Exception::class)
    fun `get user information error should have exception on stream`() {
        val exception = Throwable()
        `when`(api.getUser("WeRockStar")).thenReturn(Observable.error(exception))

        presenter.getUserInfo("WeRockStar")

        verify(view).loading()
        verify(view).getUserInfoError(exception.message)
        verify(view).dismissLoading()
        verify(view).hideKeyboard()
    }

    @After
    @Throws(Exception::class)
    fun tearDown() {
        presenter.onDestroy()
    }
}