import basic_text_sum_1 as b1
from sumy.parsers.plaintext import PlaintextParser
from sumy.nlp.stemmers import Stemmer
from sumy.nlp.tokenizers import Tokenizer

class Text_summary:
    def __init__(self):
        self.type = 0
        self.sum_sentence_num = 5
        self.lauguage = 'english'

    def text_sum_0(self, text):
        parser = PlaintextParser.from_string(text, Tokenizer(self.lauguage))
        stemmer = Stemmer(self.lauguage)
        b1.lsa_summary(parser, stemmer)

    def text_sum_1(self, text):
        pass

    def text_sum_2(self, text):
        print('text_sum_2')
        pass

    def text_sum_3(self, text):
        pass

    def text_sum_4(self, text):
        pass

    def text_sum_5(self, text):
        pass

    def text_sum_6(self, text):
        pass
    
    def text_sum_7(self, text):
        pass

    def sum_default(self, text):
        print('Text summary type is wrong...')

    def summary(self, type, text):
        self.type = type
        switchDic = {
            0: self.text_sum_0,
            1: self.text_sum_1,
            2: self.text_sum_2,
            3: self.text_sum_3,
            4: self.text_sum_4,
            5: self.text_sum_5,
            6: self.text_sum_6,
            7: self.text_sum_7
        }
        switchDic.get(type, self.sum_default)(text)

    