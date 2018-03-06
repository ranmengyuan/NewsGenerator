# NewsGenerator

NewsGenerator put forward the method of establishing the corpus and analyzing the structure of the sentence for the automatic generation of sports news. The method is to crawl millions of existing sports news in sports websites such as Sina Sports. At the same time ,analyzing the structure of each sentence by LD algorithm, keyword and semantic analysis. And the use of decision-making table makes the sentence more diverse, rich, the establishment of the corpus. From the sports live text script to the sports news automatically generated experimental tests and ROUGE value to evaluate the system generated.

# Getting started

NewsGenerator is contains DAO, BEAN, HELPER, News, ToDatabase, Main and more.

DAO, BEAN, HELPER and ToDatabase are used to control database.

News is used to analyze files that describe games and generate sports news.

Main is used to manage the total program.

# File Structure

bin contains some profile and some package needed.

src contains all source code.

dictionary is a dictionary that is used to find the sentence that describe Goals.

# Supported Platforms
NewsGenerator is based on JavaSE-1.8. If you want to operate NewsGenerator, you should download a Java interpreter and some package of java, such as
mysql-connector etc..And you should also pay attention to the form of the file that you want to deal.

# Problems
If you find a problem such as a crash, an unexpected behaviour, or something similar please visit the [issue tracker](https://github.com/ranmengyuan/NewsGenerator/issues) and report the issue.

Please be kind and search to see if the issue is already logged before creating a new one. If you're pressed for time, log it anyway.

Thanks for your interest,mengyuan.
