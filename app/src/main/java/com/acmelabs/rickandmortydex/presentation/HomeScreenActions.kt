package com.acmelabs.rickandmortydex.presentation

sealed interface HomeScreenActions {
    data object OnDialogTryAgain : HomeScreenActions
}