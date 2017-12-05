package application;

import static org.junit.Assert.*;

import org.junit.Test;

public class RegexTestHarnessTest {
    //
    //Flags
    //
    @Test
    public void testFlagCASE_INSENSITIVE_whenRegexIsAToZ_AndStringa_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("CASE_INSENSITIVE", "[A-Z]", "a").get(0);
        //assert
        assertEquals("I found the text a starting at index 0 and ending at index 1", result);
    }

    @Test
    public void testFlagCanon_EQ_whenRegexIsUnicode_AndStringUnicode_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("CANON_EQ", "a\u030A", "\u00E5").get(0);
        //assert
        assertEquals("I found the text å starting at index 0 and ending at index 1", result);
    }

    @Test
    public void testFlagCOMMENTS_whenRegexIsT_s_t_ee_AndStringTstee_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("COMMENTS", "T s t ee", "Tstee").get(0);
        //assert
        assertEquals("I found the text Tstee starting at index 0 and ending at index 5", result);
    }

    @Test
    public void testFlagDOTALL_whenRegexIsh_s_AndStringhNewLines_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("DOTALL", "h.s", "h\ns").get(0);
        //assert
        assertEquals("I found the text h\ns starting at index 0 and ending at index 3", result);
    }

    @Test
    public void testFlagLITERAL_whenRegexIs_slashd_AndString_slashd_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("LITERAL", "\\d", "\\d").get(0);
        //assert
        assertEquals("I found the text \\d starting at index 0 and ending at index 2", result);
    }

    @Test
    public void testFlagMULTILINE_whenRegexIs_hallo$_AndString_blaSlasdhallo_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("MULTILINE", "^hallo$", "blajbjdf\r\n" + "hallo").get(0);
        //assert
        assertEquals("I found the text hallo starting at index 10 and ending at index 15", result);
    }

    @Test
    public void testFlagUNIX_LINES_whenRegexIs_punktPlus_AndString_ASlashr_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("UNIX_LINES", ".+", "A\r").get(0);
        //assert
        assertEquals("I found the text A\r starting at index 0 and ending at index 2", result);
    }

    //
    //Boundary
    //
    @Test
    public void testBoundaryMatchersStartEnd_whenRegexIs_dog$_AndString_dog_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "^dog$", "dog").get(0);
        //assert
        assertEquals("I found the text dog starting at index 0 and ending at index 3", result);
    }

    @Test
    public void testBoundaryMatchersSlashG_whenRegexIs_slashbdogslasb_AndString_fisch_fisch_fisch_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\\Gfisch", "fisch fisch fisch").get(0);
        //assert
        assertEquals("I found the text fisch starting at index 0 and ending at index 5", result);
    }

    @Test
    public void testBoundaryMatchersSlashb_whenRegexIs_slashbdogslasb_AndString_the_dog_plays_in_the_yard_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\\bdog\\b", "The dog plays in the yard.").get(0);
        //assert
        assertEquals("I found the text dog starting at index 4 and ending at index 7", result);
    }

    @Test
    public void testBoundaryMatchersSlashB_whenRegexIs_slashbdogslasB_AndString_the_doggi_plays_in_the_yard_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\\bdog\\B", "The doggi plays in the yard.").get(0);
        //assert
        assertEquals("I found the text dog starting at index 4 and ending at index 7", result);
    }

    @Test
    public void testBoundaryMatchersSlashA_whenRegexIs_slashAdoggislashZ_AndString_doggi_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\\Adoggi\\Z", "doggi").get(0);
        //assert
        assertEquals("I found the text doggi starting at index 0 and ending at index 5", result);
    }

    //
    //Greedy Quntifier
    //
    @Test
    public void testGreedyQuantifier_whenRegexIs_eBetwenn2And3_AndString_eee_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "e{2,3}", "eee").get(0);
        //assert
        assertEquals("I found the text eee starting at index 0 and ending at index 3", result);
    }

    @Test
    public void testGreedyQuantifier_whenRegexIs_abcQuest_AndString_ab_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "abc?", "ab").get(0);
        //assert
        assertEquals("I found the text ab starting at index 0 and ending at index 2", result);
    }

    @Test
    public void testGreedyQuantifier_whenRegexIs_pointStar_AndString_abdfgsd_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", ".*", "abdfgsd").get(0);
        //assert
        assertEquals("I found the text abdfgsd starting at index 0 and ending at index 7", result);
    }

    @Test
    public void testGreedyQuantifier_whenRegexIs_PointPlus_AndString_abdfgsd_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", ".+", "sd ssd").get(0);
        //assert
        assertEquals("I found the text sd ssd starting at index 0 and ending at index 6", result);
    }

    @Test
    public void testGreedyQuantifier_whenRegexIs_LetterBracketLetterBracket_AndString_aa_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "a{2}", "aa").get(0);
        //assert
        assertEquals("I found the text aa starting at index 0 and ending at index 2", result);
    }

    @Test
    public void testGreedyQuantifier_whenRegexIs_BracketLetterComaBracket_AndString_aaaaa_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "a{2,}", "aaaaa").get(0);
        //assert
        assertEquals("I found the text aaaaa starting at index 0 and ending at index 5", result);
    }

    //
    //Possessive Quantifier
    //
    @Test
    public void testPossessiveQuantifier_whenRegexIs_abcQuestPlusd_AndString_abcdddd_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "abc?+d", "abcdddd").get(0);
        //assert
        assertEquals("I found the text abcd starting at index 0 and ending at index 4", result);
    }

    @Test
    public void testPossessiveQuantifier_whenRegexIs_aStarPlus_AndString_aaa_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "a*+", "aaa").get(0);
        //assert
        assertEquals("I found the text aaa starting at index 0 and ending at index 3", result);
    }

    @Test
    public void testPossessiveQuantifier_whenRegexIs_aPlusPlus_AndString_aaa_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "a++", "aaa").get(0);
        //assert
        assertEquals("I found the text aaa starting at index 0 and ending at index 3", result);
    }

    @Test
    public void testPossessiveQuantifier_whenRegexIs_aBracketLetterComaLetterBracketPlusa_AndString_aaaaa_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "a{2,4}+a", "aaaaa").get(0);
        //assert
        assertEquals("I found the text aaaaa starting at index 0 and ending at index 5", result);
    }

    @Test
    public void testPossessiveQuantifier_whenRegexIs_aBracketLetterComaBracketPlus_AndString_aaaaa_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "a{2,}+", "aaaaa").get(0);
        //assert
        assertEquals("I found the text aaaaa starting at index 0 and ending at index 5", result);
    }

    @Test
    public void testPossessiveQuantifier_whenRegexIs_aBracketNumberBracketPlusa_AndString_aaa_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "a{2}+a", "aaaaa").get(0);
        //assert
        assertEquals("I found the text aaa starting at index 0 and ending at index 3", result);
    }

    //
    //Reluctant Quantifier
    //
    @Test
    public void testReluctantQuantifier_whenRegexIs_aQuestQuestaaa_AndString_bbaaa_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "a??aaa", "bbaaa").get(0);
        //assert
        assertEquals("I found the text aaa starting at index 2 and ending at index 5", result);
    }

    @Test
    public void testReluctantQuantifier_whenRegexIs_aStarQuestaa_AndString_aaa_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "a*?aa", "aaaa").get(0);
        //assert
        assertEquals("I found the text aa starting at index 0 and ending at index 2", result);
    }

    @Test
    public void testReluctantQuantifier_whenRegexIs_aPlusQuest_AndString_aaaaaaa_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "a+?", "aaaaaaa").get(0);
        //assert
        assertEquals("I found the text a starting at index 0 and ending at index 1", result);
    }

    @Test
    public void testReluctantQuantifier_whenRegexIs_aBracketNumbBracketQuest_AndString_aaaaaaa_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "a{2}?", "aaaaaaa").get(0);
        //assert
        assertEquals("I found the text aa starting at index 0 and ending at index 2", result);
    }

    @Test
    public void testReluctantQuantifier_whenRegexIs_aBracketNumbComaBracketQuest_AndString_aaaaaaa_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "a{2,}?", "aaaaaaa").get(0);
        //assert
        assertEquals("I found the text aa starting at index 0 and ending at index 2", result);
    }

    @Test
    public void testReluctantQuantifier_whenRegexIs_aBracketNumbComaNumbBracketQuest_AndString_aaaaaaa_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "a{2,4}?", "aaaaaaa").get(0);
        //assert
        assertEquals("I found the text aa starting at index 0 and ending at index 2", result);
    }
    //
    //Character Classes
    //

    @Test
    public void testCharacterClasses_whenRegexIs_dot_AndString_a_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", ".", "a").get(0);
        //assert
        assertEquals("I found the text a starting at index 0 and ending at index 1", result);
    }

    @Test
    public void testCharacterClasses_whenRegexIs_slashd_AndString_1_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\\d", "1").get(0);
        //assert
        assertEquals("I found the text 1 starting at index 0 and ending at index 1", result);
    }

    @Test
    public void testCharacterClasses_whenRegexIs_slashD_AndString_abcd_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\\D", "abcd").get(0);
        //assert
        assertEquals("I found the text a starting at index 0 and ending at index 1", result);
    }

    @Test
    public void testCharacterClasses_whenRegexIs_slashs_AndString_slashn_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\\s", "\n").get(0);
        //assert
        assertEquals("I found the text \n starting at index 0 and ending at index 1", result);
    }

    @Test
    public void testCharacterClasses_whenRegexIs_slashS_AndString_h_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\\S", "h").get(0);
        //assert
        assertEquals("I found the text h starting at index 0 and ending at index 1", result);
    }

    @Test
    public void testCharacterClasses_whenRegexIs_slashw_AndString_h_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\\w", "h").get(0);
        //assert
        assertEquals("I found the text h starting at index 0 and ending at index 1", result);
    }

    @Test
    public void testCharacterClasses_whenRegexIs_slashW_AndString_Slash_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\\W", " ").get(0);
        //assert
        assertEquals("I found the text   starting at index 0 and ending at index 1", result);
    }

    @Test
    public void testCharacterClasses_whenRegexIs_slashpLower_AndString_a_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\\p{Lower}", "a").get(0);
        //assert
        assertEquals("I found the text a starting at index 0 and ending at index 1", result);
    }

    @Test
    public void testCharacterClasses_whenRegexIs_slashpLu_AndString_a_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\\p{Lu}", "A").get(0);
        //assert
        assertEquals("I found the text A starting at index 0 and ending at index 1", result);
    }

    @Test
    public void testCharacterClasses_whenRegexIs_slashp_AndString_Space_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\\p{Z}", " ").get(0);
        //assert
        assertEquals("I found the text   starting at index 0 and ending at index 1", result);
    }

    @Test
    public void testCharacterClasses_whenRegexIs_slashpSymbol_AndString_Plus_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\\p{S}", "+").get(0);
        //assert
        assertEquals("I found the text + starting at index 0 and ending at index 1", result);
    }

    @Test
    public void testCharacterClasses_whenRegexIs_slashpN_AndString_1_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\\p{N}", "1").get(0);
        //assert
        assertEquals("I found the text 1 starting at index 0 and ending at index 1", result);
    }

    @Test
    public void testCharacterClasses_whenRegexIs_slashpPunct_AndString_point_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\\p{Punct}", ".").get(0);
        //assert
        assertEquals("I found the text . starting at index 0 and ending at index 1", result);
    }

    @Test
    public void testCharacterClasses_whenRegexIs_slashpUpper_AndString_A_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\\p{Upper}", "A").get(0);
        //assert
        assertEquals("I found the text A starting at index 0 and ending at index 1", result);
    }

    @Test
    public void testCharacterClasses_whenRegexIs_slashpASCII_AndString_A_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\\p{ASCII}", "A").get(0);
        //assert
        assertEquals("I found the text A starting at index 0 and ending at index 1", result);
    }

    @Test
    public void testCharacterClasses_whenRegexIs_slashpAlpha_AndString_A_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\\p{Alpha}", "A").get(0);
        //assert
        assertEquals("I found the text A starting at index 0 and ending at index 1", result);
    }

    @Test
    public void testCharacterClasses_whenRegexIs_slashpDigit_AndString_1_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\\p{Digit}", "1").get(0);
        //assert
        assertEquals("I found the text 1 starting at index 0 and ending at index 1", result);
    }

    @Test
    public void testCharacterClasses_whenRegexIs_slashpAlnum_AndString_A1_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\\p{Alnum}*", "A1").get(0);
        //assert
        assertEquals("I found the text A1 starting at index 0 and ending at index 2", result);
    }

    @Test
    public void testCharacterClasses_whenRegexIs_slashpGraph_AndString_A1Point_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\\p{Graph}*", "A1.").get(0);
        //assert
        assertEquals("I found the text A1. starting at index 0 and ending at index 3", result);
    }

    @Test
    public void testCharacterClasses_whenRegexIs_slashpPrint_AndString_A1Point_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\\p{Print}*", "A1.").get(0);
        //assert
        assertEquals("I found the text A1. starting at index 0 and ending at index 3", result);
    }

    @Test
    public void testCharacterClasses_whenRegexIs_slashpBlank_AndString_Tab_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\\p{Blank}*", "\t").get(0);
        //assert
        assertEquals("I found the text \t starting at index 0 and ending at index 1", result);
    }

    @Test
    public void testCharacterClasses_whenRegexIs_slashpCntrl_AndString_Tab_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\\p{Cntrl}*", "\t").get(0);
        //assert
        assertEquals("I found the text \t starting at index 0 and ending at index 1", result);
    }

    @Test
    public void testCharacterClasses_whenRegexIs_slashpXDigit_AndString_3E9_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\\p{XDigit}*", "3E9").get(0);
        //assert
        assertEquals("I found the text 3E9 starting at index 0 and ending at index 3", result);
    }

    @Test
    public void testCharacterClasses_whenRegexIs_slashpSpace_AndString_Space_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\\p{Space}*", " ").get(0);
        //assert
        assertEquals("I found the text   starting at index 0 and ending at index 1", result);
    }

    //
    //Character Escapes
    //
    @Test
    public void testCharacterEscapes_whenRegexIs_slashB_AndString_DuIsstDasJetzt_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\\Bss\\B", "Du isst das jetzt!").get(0);
        //assert
        assertEquals("I found the text ss starting at index 4 and ending at index 6", result);
    }

    @Test
    public void testCharacterEscapes_whenRegexIs_slashb_AndString_DuIsstDasJetzt_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\\bisst\\b", "Du isst das jetzt!").get(0);
        //assert
        assertEquals("I found the text isst starting at index 3 and ending at index 7", result);
    }

    @Test
    public void testCharacterEscapes_whenRegexIs_slasht_AndString_TAB_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\t", "\t").get(0);
        //assert
        assertEquals("I found the text " + "\t" + " starting at index 0 and ending at index 1", result);
    }

    @Test
    public void testCharacterEscapes_whenRegexIs_slashn_AndString_NewLine_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "\\n", "\n").get(0);
        //assert
        assertEquals("I found the text \n starting at index 0 and ending at index 1", result);
    }

    //
    //Metacharacter
    //
    @Test
    public void testMetachar_whenRegexIs_dachFoo$_AndString_Foo_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "^Foo$", "Foo").get(0);
        //assert
        assertEquals("I found the text Foo starting at index 0 and ending at index 3", result);
    }

    @Test
    public void testMetaChar_whenRegexIs_dachFoo$_AndString_Foo_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "^Foo$", "Foo").get(0);
        //assert
        assertEquals("I found the text Foo starting at index 0 and ending at index 3", result);
    }

    @Test
    public void testMetaChar_whenRegexIs_dachFooStar_AndString_Foo_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "(Foo)*", "Fsoo").get(0);
        //assert
        assertEquals("I found the text  starting at index 0 and ending at index 0", result);
    }

    @Test
    public void testMetaChar_whenRegexIs_FooPlus_AndString_Foo_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "(Foo)+", "Foo").get(0);
        //assert
        assertEquals("I found the text Foo starting at index 0 and ending at index 3", result);
    }

    @Test
    public void testMetaChar_whenRegexIs_FooQuest_AndString_Foo_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "(Foo)?", "Foo").get(0);
        //assert
        assertEquals("I found the text Foo starting at index 0 and ending at index 3", result);
    }

    //
    //Logic Operators
    //
    @Test
    public void testLogicOperatorsAnd_whenRegexIs_And_AndString_1_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "(?=\\d)(?=\\p{N})", "1").get(0);
        //assert
        assertEquals("I found the text  starting at index 0 and ending at index 0", result);
    }

    @Test
    public void testLogicOperatorsOr_whenRegexIs_Or_AndString_part2_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "((^|, )(fisch|fuchs|Otter))+$", "fisch").get(0);
        //assert
        assertEquals("I found the text fisch starting at index 0 and ending at index 5", result);
    }

    @Test
    public void testLogicOperatorsAndUngleich_whenRegexIs_AndUngleich_AndString_1_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "(?!=\\d)(?!=[1-9])", "a").get(0);
        //assert
        assertEquals("I found the text  starting at index 0 and ending at index 0", result);
    }

    ///
    ///Capturing group groupCount()
    ///
    @Test
    public void testCapturingGroup_whenRegexIs_abcBracket3Bracket_AndString_abcabcabc_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "(abc){3}", "abcabcabc").get(0);
        //assert
        assertEquals("I found the text abcabcabc starting at index 0 and ending at index 9", result);
    }

    @Test
    public void testCapturingGroup_MatchGroupCount_And4Groups_thenReturn4() {
        //arrange
        final Controller testee = new Controller();
        //act
        testee.makeRegexAndTestIt("", "((A)(B(C))){3}", "ABCABCABC").get(0);
        final int gpNr = testee.getNumberOfGroups();
        //assert
        assertEquals(4, gpNr);
    }

    ///
    ///Capturing group Backreferences
    ///
    @Test
    public void testCapturingGroup_whenRegexIs_slashdslashdSlash2_AndString_1212_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "(\\d\\d)\\1", "1212").get(0);
        //assert
        assertEquals("I found the text 1212 starting at index 0 and ending at index 4", result);
    }

    ///
    ///Non-Capturing group
    ///
    @Test
    public void testNonCapturingGroup_whenRegexIs_QuestabcBracket3Bracket_AndString_abcabcabc_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "(?:abc){3}", "abcabcabc").get(0);
        //assert
        assertEquals("I found the text abcabcabc starting at index 0 and ending at index 9", result);
    }

    ///
    ///Custom Character Classes
    ///
    @Test
    public void testCustomCharacterClasses_whenRegexIs_BracketabcdefBracketBracket2Bracket_AndString_abcdef_thenReturnStringResultThatMatchs() {
        //arrange
        final Controller testee = new Controller();
        //act
        final String result = testee.makeRegexAndTestIt("", "(abcdef){2}", "abcdefabcdef").get(0);
        //assert
        assertEquals("I found the text abcdefabcdef starting at index 0 and ending at index 12", result);
    }
}
