package com.p2p.service;

import com.p2p.domain.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

// Import "CCTV" dari Log4j
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoanServiceTest {
    // Pasang CCTV-nya di kelas ini
    private static final Logger logger = LogManager.getLogger(LoanServiceTest.class);

    @Test
    void shouldRejectLoanWhenBorrowerNotVerified() {

        // =====================================================
        // SCENARIO:
        // Borrower tidak terverifikasi (KYC = false)
        // Ketika borrower mengajukan pinjaman
        // Maka sistem harus menolak dengan melempar exception
        // =====================================================

        // Logger info
        logger.info("Begin Test Case 1: Borrower aint verified");

        // =========================
        // Arrange (Initial Condition)
        // =========================
        // Borrower belum lolos proses KYC
        Borrower borrower = new Borrower(false, 700);

        // Service untuk pengajuan loan
        LoanService loanService = new LoanService();

        // Jumlah pinjaman valid
        BigDecimal amount = BigDecimal.valueOf(1000);

        // Logger Debug
        logger.debug("Verifying, check score, and check amount of data...");

        // =========================
        // Act + Assert
        // =========================
        // KOREKSI 2: Bungkus pemanggilan dengan assertThrows
        // agar JUnit tahu kita memang "berharap" sistem akan menolak
        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        });

        logger.info("System succesfully rejecting!");
    }

    @Test
    void shouldRejectLoanWhenAmountsZeroOrNegative() {
        // Logger info
        logger.info("Begin Test Case 2: Amount aint valid");

        // Kasus
        Borrower borrower = new Borrower(true, 601);
        LoanService loanService = new LoanService();

        BigDecimal amount0 = BigDecimal.ZERO;
        BigDecimal amountmin = BigDecimal.valueOf(-100);

        // Logger Debug
        logger.debug("Verifying, check score, and check amount of data...");

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amountmin);
        });

        logger.info("System succesfully rejecting!");
    }

    @Test
    void shouldApproveLoanWhenCreditScoreHigh() {
        // Logger info
        logger.info("Begin Test Case 3: Credit good to go");

        // Kasus
        Borrower borrower = new Borrower(true, 600);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        // Logger Debug
        logger.debug("Verifying, check score, and check amount of data...");

        // Act + Assert
        Loan loanResult = loanService.createLoan(borrower, amount);
        assertEquals(Loan.Status.APPROVED, loanResult.getStatus());

        logger.info("System alr do something, good job!");
    }

    @Test
    void shouldRejectLoanWhenCreditScoreLow() {
        // Logger info
        logger.info("Begin Test Case 4: Credit got no entry");

        // Kasus
        Borrower borrower = new Borrower(true, 599);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        // Logger Debug
        logger.debug("Verifying, check score, and check amount of data...");

        // Act + Assert
        Loan loanResult = loanService.createLoan(borrower, amount);
        assertEquals(Loan.Status.REJECTED, loanResult.getStatus());

        logger.info("System alr do something, good job!");
    }
}

