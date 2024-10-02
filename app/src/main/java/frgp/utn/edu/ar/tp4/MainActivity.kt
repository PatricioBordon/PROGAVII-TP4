package frgp.utn.edu.ar.tp4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.PrimaryTabRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import frgp.utn.edu.ar.tp4.ui.theme.TP4Theme

class MainActivity : ComponentActivity() {
    val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TP4Theme {
                ScaffoldView(
                    modifier = Modifier,
                    viewModel = viewModel
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldView(modifier: Modifier = Modifier, viewModel: MainViewModel) {

    val state = viewModel.selectedTabIndex
    val titles = listOf("Crear", "Modificar", "Listar")

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            PrimaryTabRow(selectedTabIndex = state) {
                titles.forEachIndexed { index, title ->
                    Tab(
                        selected = state == index,
                        onClick = { viewModel.onTabSelected(index) },
                        text = { Text(text = title, maxLines = 2, overflow = TextOverflow.Ellipsis) }
                    )
                }
            }
        }
    ) { it ->
        Column(modifier = Modifier.padding(it)) {
            Box(
                modifier = Modifier
                    .paddingFromBaseline(32.dp)
                    .fillMaxSize()
            ) {
                when (state) {
                    0 -> CrearTabContent(viewModel)
                    1 -> ModificarTabContent(viewModel)
                    2 -> ListarTabContent(viewModel)
                }
            }
        }
    }
}

@Composable
fun CrearTabContent(viewModel: MainViewModel) {

    
}

@Composable
fun ModificarTabContent(viewModel: MainViewModel) {

}

@Composable
fun ListarTabContent(viewModel: MainViewModel) {

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TP4Theme {
        ScaffoldView(modifier = Modifier, viewModel = MainViewModel())
    }
}