import android.annotation.SuppressLint
import android.view.ContextThemeWrapper
import android.widget.FrameLayout
import androidx.annotation.CallSuper
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.viewbinding.ViewBinding
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.AdapterDelegatesManager
import com.hannesdorfmann.adapterdelegates4.dsl.AdapterDelegateViewBindingViewHolder
import com.sriram.mocknbc.R
import dagger.hilt.android.components.ViewComponent
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mockito.mockStatic
import org.robolectric.annotation.LooperMode

@LooperMode(LooperMode.Mode.PAUSED)
@RunWith(AndroidJUnit4::class)
abstract class BaseAdapterDelegateTest<I, T : I, V : ViewBinding> {

    @SuppressLint("CheckResult")
    @Before
    @CallSuper
    open fun setup() {
        mockStatic(ViewComponent::class.java)
    }

    @After
    open fun tearDown() {
    }

    abstract fun createDelegate(): AdapterDelegate<List<I>>

    protected fun testBinding(
        item: I,
        body: AdapterDelegateViewBindingViewHolder<T, V>.() -> Unit,
    ) {
        val delegate = createDelegate()
        val delegatesManager = AdapterDelegatesManager<List<I>>()
            .addDelegate(VIEW_TYPE, delegate)
        val vh = delegatesManager.onCreateViewHolder(
            FrameLayout(createContext()),
            VIEW_TYPE,
        )
        delegatesManager.onBindViewHolder(listOf(item), 0, vh)

        vh as AdapterDelegateViewBindingViewHolder<T, V>
        body(vh)
    }

    companion object {
        private const val VIEW_TYPE = -1
    }
}

fun createContext(): ContextThemeWrapper = ContextThemeWrapper(
    ApplicationProvider.getApplicationContext(),
    R.style.Theme_MockNBC,
)
