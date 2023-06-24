package devapp.lanze.motivation.data

import devapp.lanze.motivation.classes.MotivationDataKeys
import kotlin.random.Random




class PharaseMock() {

    private val all = MotivationDataKeys.FILTER.ALL
    private val smile = MotivationDataKeys.FILTER.SMILE
    private val sunny = MotivationDataKeys.FILTER.SUNNY


    private val mListPhrase = listOf<Phrase>(
        Phrase("Não sabendo que era impossível, foi lá e fez.", smile),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", smile),
        Phrase("Quando está mais escuro, vemos mais estrelas!", smile),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", smile),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", smile),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", smile),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", sunny),
        Phrase("Você perde todas as chances que você não aproveita.", sunny),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", sunny),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", sunny),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", sunny),
        Phrase("Se você acredita, faz toda a diferença.", sunny),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", sunny),
        Phrase("Inove, experimente e obtenha resultados diferentes. A insanidade está na repetição sem mudança.", smile),
        Phrase("O sabor do sucesso é temperado pelo fracasso, pois é nas adversidades que crescemos.", smile),
        Phrase("Grandes sonhos exigem ação ousada e determinação incansável.", sunny)

    )


    fun getPhrase(categoryId: Int): String {
       val filteredPhrases = mListPhrase.filter { it.categoryId == categoryId || categoryId == all}
        return filteredPhrases[Random.nextInt(filteredPhrases.size)].pharase

    }

}