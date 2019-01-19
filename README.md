# stackoverflow-data-mining

#### ​Motivation

* Mining Stackoverflow & Use NLP technologies to find something interesting.

#### Functions

* You can input some terms and we will fetch all related questions&answers in SO.（Support tag search currently）
* Analysis questions contents & Generate a Topic Model（lda/lsi）
* Use the model, you can find similar questions. (not too precise, improve in the future)
* Analysis the words & tags in questions
* Extract answers' summary to help developers find what they want. (Support 6 summary algorithms)
* Extract `Java` codes snippets in Questions & Answers, find apis that developers care most or often have problems with. (The codes can also be leveraged in many fields, such as generate a summary for a code snippet, and we are exploring it.)

####Setup

* Prerequisites
    * python >= 2.7
    * Java >= 1.8

* Installation

    * python packages:

        ```
        numpy; matplotlib; nltk; gensim; wordcloud; sumy; argparse
        ```

    * Java maven dependencies:

        ```
        jdt.core; guava; xchart; junit
        ```

#### Usage

* First `cd Py-StackExchange`, download the Q&A information. It is implemented based on the project [py-stackexchange](https://github.com/lucjon/Py-StackExchange). The infomation will save in files, the files' path can be set in `common.py`, Then run `python download.py`

  ```
  $ python download.py -h
  usage: download.py [-h] [--type TYPE] term
  
  positional arguments:
    term         your search tag
  
  optional arguments:
    -h, --help   show this help message and exit
    --type TYPE  choose download type: 1 - only questions; 2 - questions &
                 answers)
  ```

* After get the data, you can start analysis, run `python analysis.py`

  ```
  $ python analysis.py -h
  usage: analysis.py [-h] [--topic TOPIC] [--tfidf TFIDF] [--word WORD]
                     [--tag TAG] [--summary SUMMARY]
                     term
  
  positional arguments:
    term               your search tag
  
  optional arguments:
    -h, --help         show this help message and exit
    --topic TOPIC      choose topic model: 0 - no; 1 - lsa; 2 - lda
    --tfidf TFIDF      use tfidf vertor: 0 - no;1 - yes
    --word WORD        choose word count: 1 - wordcount&cloud;
    --tag TAG          choose tag count: 1 - tagcount;
    --summary SUMMARY  choose summary algorithm: 0 - LSA; 1 - LEX_RANK; 2 -
                       TEXT_RANK; 3 - SUM_BASIC; 4 - Submodular1; 5 -
                       Submodular2; 6 - TextTeaser; 7 - MMR
  ```

* If you choose download type '2', we will save the Java code snippets in Q&As. Then, we can analysis the code data by `JavaCodeParser`
  * Import the project `JavaCodeParser` into IDE (e.g. Idea, etc)
  * Run `Main.java`

####  Content of the repository



