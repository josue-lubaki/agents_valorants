import SwiftUI
import shared

@main
struct iOSApp: App {

    init(){
        KoinHelperKt.doInitKoin()
    }

	var body: some Scene {
		WindowGroup {
		    ZStack {
		        Color.white.ignoresSafeArea(.all) // status bar color
			    ContentView()
			}.preferredColorScheme(.light)
		}
	}
}
