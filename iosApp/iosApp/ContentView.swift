import SwiftUI
import guyub

struct ContentView: View {
	var body: some View {
            ComposeView() // Compose has own keyboard handler
        }
}

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        Platform_iosKt.SingleFormView(data: FakeData.init().singleFormData)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}
