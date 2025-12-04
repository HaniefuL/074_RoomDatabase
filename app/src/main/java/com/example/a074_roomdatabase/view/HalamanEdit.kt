package com.example.a074_roomdatabase.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.a074_roomdatabase.viewmodel.EditViewModel
import com.example.a074_roomdatabase.viewmodel.provider.PenyediaViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditSiswaScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EditViewModel = viewModel(factory = PenyediaViewModel.Factory)
){    Scaffold(
    topBar = {
        SiswaTopAppBar(
            title = stringResource(DestinasiEditSiswa.titleRes),
            canNavigateBack = true,
            navigateUp = onNavigateUp
        )
    },
    modifier = modifier
) { innerPadding ->
    val coroutineScope = rememberCoroutineScope()

    EntrySiswaBody(
        uiStateSiswa = viewModel.uiStateSiswa,
        onSiswaValueChange = viewModel::updateUIState,
        onSaveClick = {
            coroutineScope.launch {
                viewModel.updateSiswa()
                navigateBack()
            }
        },
        modifier = Modifier.padding(innerPadding)
    )
}}