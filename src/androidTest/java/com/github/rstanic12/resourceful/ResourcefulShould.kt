package com.github.rstanic12.resourceful

import android.os.Looper
import androidx.test.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ResourcefulShould {

    companion object {
        private const val TEST_FRAGMENT_TAG = "test_fragment_tag"
        private const val SUPPORT_TEST_FRAGMENT_TAG = "support_test_fragment_tag"

        private const val TEST_DIALOG_FRAGMENT_TAG = "test_dialog_tag"
        private const val TEST_SUPPORT_DIALOG_FRAGMENT_TAG = "test_support_dialog_tag"

        private val context = InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Suppress("MemberVisibilityCanBePrivate")
    @get:Rule val testActivityRule = ActivityTestRule<TestActivity>(TestActivity::class.java, true, false)

    @Test
    fun bindResourcesInView() {
        val testView = TestView(context)
        assertNotNull(testView.color)
        assertNotNull(testView.dimen)
        assertNotNull(testView.dimenPx)
        assertNotNull(testView.string)
    }

    @Test
    fun bindResourcesInActivity() {
        val testActivity = testActivityRule.launchActivity(null)
        assertNotNull(testActivity.color)
        assertNotNull(testActivity.dimen)
        assertNotNull(testActivity.dimenPx)
        assertNotNull(testActivity.string)
    }

    @Test
    fun bindResourcesInDialog() {
        Looper.prepare()
        val testDialog = TestDialog(context)
        assertNotNull(testDialog.color)
        assertNotNull(testDialog.dimen)
        assertNotNull(testDialog.dimenPx)
        assertNotNull(testDialog.string)
    }

    @Test
    fun bindResourcesInDialogFragment() {
        val testDialogFragment = TestDialogFragment()
        val testActivity = testActivityRule.launchActivity(null)
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            testDialogFragment.show(testActivity.fragmentManager, TEST_DIALOG_FRAGMENT_TAG)
        }
        InstrumentationRegistry.getInstrumentation().waitForIdleSync()

        assertNotNull(testDialogFragment.color)
        assertNotNull(testDialogFragment.dimen)
        assertNotNull(testDialogFragment.dimenPx)
        assertNotNull(testDialogFragment.string)
    }

    @Test
    fun bindResourcesInSupportDialogFragment() {
        val testSupportDialogFragment = TestSupportDialogFragment()
        val testActivity = testActivityRule.launchActivity(null)
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            testSupportDialogFragment.show(testActivity.supportFragmentManager, TEST_SUPPORT_DIALOG_FRAGMENT_TAG)
        }
        InstrumentationRegistry.getInstrumentation().waitForIdleSync()

        assertNotNull(testSupportDialogFragment.color)
        assertNotNull(testSupportDialogFragment.dimen)
        assertNotNull(testSupportDialogFragment.dimenPx)
        assertNotNull(testSupportDialogFragment.string)
    }

    @Test
    fun bindResourcesInFragment() {
        val testFragment = TestFragment()
        val testActivity = testActivityRule.launchActivity(null)
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            testActivity.fragmentManager
                    .beginTransaction()
                    .add(testFragment, TEST_FRAGMENT_TAG)
                    .commitNow()
        }

        assertNotNull(testFragment.color)
        assertNotNull(testFragment.dimen)
        assertNotNull(testFragment.dimenPx)
        assertNotNull(testFragment.string)
    }

    @Test
    fun bindResourcesInSupportFragment() {
        val testSupportFragment = TestSupportFragment()
        val testActivity = testActivityRule.launchActivity(null)
        InstrumentationRegistry.getInstrumentation().runOnMainSync{
            testActivity.supportFragmentManager
                    .beginTransaction()
                    .add(testSupportFragment, SUPPORT_TEST_FRAGMENT_TAG)
                    .commitNow()
        }

        assertNotNull(testSupportFragment.color)
        assertNotNull(testSupportFragment.dimen)
        assertNotNull(testSupportFragment.dimenPx)
        assertNotNull(testSupportFragment.string)
    }

    @Test
    fun bindResourcesInViewHolder() {
        val itemView = TestView(context)
        val testViewHolder = TestRecyclerViewHolder(itemView)

        assertNotNull(testViewHolder.color)
        assertNotNull(testViewHolder.dimen)
        assertNotNull(testViewHolder.dimenPx)
        assertNotNull(testViewHolder.string)
    }

    @Test
    fun bindResourcesInResourceable() {
        val testResourceable = TestResourceable(context)

        assertNotNull(testResourceable.color)
        assertNotNull(testResourceable.dimen)
        assertNotNull(testResourceable.dimenPx)
        assertNotNull(testResourceable.string)
    }
}