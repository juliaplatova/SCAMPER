import SwiftUI
import shared

struct ContentView: View {
    let provider = QuoteProvider()
    
    @State private var selectedLetter: Character? = nil
    @State private var verbs: [String] = []
    @State private var quote: String?

    var body: some View {
        VStack(alignment: .leading) {
            HStack {
                ForEach(["S", "C", "A", "M", "P", "E", "R"], id: \.self) { letter in
                    Button(action: {
                        provider.doNewRandomQuoteForCategory(letter: String(letter).utf16.first!)
                        
                        verbs = provider.getVerbs() ?? []
                        quote = provider.getQuote()
                        
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

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
