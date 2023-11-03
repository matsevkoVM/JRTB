package com.github.javarushcommunity.jrtb.repository;

import com.github.javarushcommunity.jrtb.repository.entity.TelegramUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

/**
 * Integration-level testing for {@link TelegramUserRepository}.
 */
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class TelegramUserRepositoryIT{

    @Autowired
    private TelegramUserRepository telegramUserRepository;

    @Sql(scripts = {"/sql/clear_db.sql", "/sql/telegram_users.sql"})
    @Test
    public void shouldProperlyFindAllActiveUsers(){

        List<TelegramUser> userList = telegramUserRepository.findAllByActiveTrue();

        Assertions.assertEquals(5, userList.size());
    }

    @Sql(scripts = {"/sql/clear_db.sql"})
    @Test
    public void shouldProperlySaveTelegramUser(){
        String chatId = "987654321";
        TelegramUser user = new TelegramUser(chatId, false);
        telegramUserRepository.save(user);

        Optional<TelegramUser> savedUser = telegramUserRepository.findById(chatId);

        Assertions.assertTrue(savedUser.isPresent());
        Assertions.assertEquals(user, savedUser.get());
    }
}
