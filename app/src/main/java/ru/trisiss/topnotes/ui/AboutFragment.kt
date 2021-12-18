package ru.trisiss.topnotes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.composethemeadapter.MdcTheme
import ru.trisiss.topnotes.BuildConfig
import ru.trisiss.topnotes.R

/**
 * Created by trisiss on 12/18/2021.
 */
class AboutFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about, container, false)
        val testView: ComposeView = view.findViewById(R.id.test)
        testView.setContent {
            MdcTheme {
                Content()
            }
        }
        val toolbar: Toolbar = view.findViewById(R.id.toolbar_about)
        toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
        return view
    }
}

@Composable
private fun Content() {
    Column(
        Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        AppName()
        Column {
            Text(
                text = "Author: Trisiss (Pavel Smirnykh)",
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
                    .padding(vertical = 5.dp)
            )
            VersionText()
        }
    }
}

@Composable
private fun AppName() {
    Text(
        text = stringResource(R.string.app_name),
        style = MaterialTheme.typography.h5,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}

@Composable
private fun VersionText() {
    Text(
        text = "Version: ${BuildConfig.VERSION_NAME}",
        style = MaterialTheme.typography.subtitle2,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}

@Preview
@Composable
private fun ContentPreview() {
    Content()
}
