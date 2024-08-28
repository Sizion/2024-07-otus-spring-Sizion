package ru.otus.hw.service;

import lombok.RequiredArgsConstructor;
import ru.otus.hw.dao.QuestionDao;
import ru.otus.hw.domain.Answer;
import ru.otus.hw.domain.Question;

@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final IOService ioService;

    private final QuestionDao questionDao;

    @Override
    public void executeTest() {
        ioService.printLine("");
        ioService.printFormattedLine("Please answer the questions below%n");
        // Получить вопросы из дао и вывести их с вариантами ответов
        //      ioService.printLine(questionDao.findAll().toString());

        for (Question question : questionDao.findAll()) {
            ioService.printLine("Question - " + question.text());
            for (Answer answer : question.answers()) {
                ioService.printFormattedLine("  answer - " + answer.text());
            }
            ioService.printLine("----------------------------------------");
        }
    }
}
