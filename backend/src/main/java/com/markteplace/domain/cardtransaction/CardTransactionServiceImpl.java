package com.markteplace.domain.cardtransaction;

import com.markteplace.core.generic.AbstractEntityRepository;
import com.markteplace.core.generic.AbstractEntityServiceImpl;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class CardTransactionServiceImpl extends AbstractEntityServiceImpl<CardTransaction> implements CardTransactionService {
    public CardTransactionServiceImpl(AbstractEntityRepository<CardTransaction> repository, Logger logger) {
        super(repository, logger);
    }
}
