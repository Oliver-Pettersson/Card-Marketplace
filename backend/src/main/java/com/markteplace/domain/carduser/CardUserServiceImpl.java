package com.markteplace.domain.carduser;

import com.markteplace.core.error.InvalidStringException;
import com.markteplace.core.generic.AbstractEntityRepository;
import com.markteplace.core.generic.AbstractEntityServiceImpl;
import com.markteplace.domain.card.Card;
import com.markteplace.domain.card.CardService;
import com.markteplace.domain.user.User;
import com.markteplace.domain.user.UserService;
import org.slf4j.Logger;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class CardUserServiceImpl extends AbstractEntityServiceImpl<CardUser> implements CardUserService {
    private CardService cardService;
    private UserService userService;
    private static final int BOOSTER_PACK_PRICE = 100;
    private static final int CARDS_IN_BOOSTER_PACK = 5;
    private static final Random random = new Random();


    public CardUserServiceImpl(AbstractEntityRepository<CardUser> repository, Logger logger, CardService cardService, UserService userService) {
        super(repository, logger);
        this.cardService = cardService;
        this.userService = userService;
    }

    @Override
    public Collection<CardUser> boosterPack() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.getCoins() < BOOSTER_PACK_PRICE) throw new InvalidStringException("User does not have enough money");

        user.setCoins(user.getCoins() - BOOSTER_PACK_PRICE);
        List<Card> cards = cardService.findAll();
        List<CardUser> newCards = new ArrayList<>();
        for (int i = 0; i < CARDS_IN_BOOSTER_PACK; i++) {
            newCards.add(create(new CardUser(cards.get(random.nextInt(cards.size())), user)));
        }

        return newCards;
    }

    @Override
    public CardUser findCardFromUser(String userId, String cardId) {
        return ((CardUserRepository) repository).findByUserAndCard(userService.findById(userId), cardService.findById(cardId));
    }
}
