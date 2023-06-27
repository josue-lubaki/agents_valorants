//package presentation.detail
//
//
//sealed class DetailState {
//    object Idle: DetailState()
//    object Loading: DetailState()
//    data class Success(val movie: Movie): DetailState()
//    data class Error(val errorMessage: String?): DetailState()
//}