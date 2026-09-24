package com.example.shardedsagawallet.repositories;

import java.util.List;
import java.util.Optional;
import java.math.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.shardedsagawallet.entities.Wallet;

import jakarta.persistence.LockModeType;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, Long> {

    // keep as-is (used for reads)
    List<Wallet> findByUserId(Long userId);

    // ⚠️ Method name lies, but query is now CORRECT
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT w FROM Wallet w WHERE w.id = :id")
    Optional<Wallet> findByIdWithLock(@Param("id") Long id);

    // ⚠️ Same here — update by WALLET ID now
    @Modifying
    @Query("UPDATE Wallet w SET w.balance = :balance WHERE w.id = :userId")
    void updateBalanceByUserId(
        @Param("userId") Long walletId,
        @Param("balance") BigDecimal balance
    );
}
