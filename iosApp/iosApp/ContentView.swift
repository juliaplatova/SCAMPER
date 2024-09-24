import SwiftUI
import shared

struct IdeaGeneratorView: View {
    let viewModel = IdeaGeneratorViewModel()
    
    @State private var selectedLetter: Character? = nil
    @State private var verbs: [String] = []
    @State private var quote: String?

    var body: some View {
        VStack(alignment: .leading) {
            HStack {
                ForEach(["S", "C", "A", "M", "P", "E", "R"], id: \.self) { letter in
                    Button(action: {
                        viewModel.quoteProvider.doNewRandomQuoteForCategory(letter: String(letter).utf16.first!)
                        
                        verbs = viewModel.quoteProvider.getVerbs() ?? []
                        quote = viewModel.quoteProvider.getQuote()
                        
                        selectedLetter = Character(letter)
                    }) {
                        Text(letter)
                            .padding(5.0)
                    }
                    .background(selectedLetter == Character(letter) ? Color.blue : Color.gray)
                    .foregroundColor(.white)
                    .cornerRadius(8)
                }
                Spacer()
            }
            .padding()

            Text("Глаголы: \(verbs.joined(separator: ", "))")
                .font(.title2)
                .padding()
            
            if let quote = quote {
                Text("Цитата: \(quote)")
                    .font(.body)
                    .padding()
            }
            Spacer()
        }
        .padding()
    }
}

struct ContentView: View {
    var body: some View {
        IdeaGeneratorView()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
