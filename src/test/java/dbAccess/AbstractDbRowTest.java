package dbAccess;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class AbstractDbRowTest {
    private AbstractDbRow abstractDbRow;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void newItemNotNull() {
        abstractDbRow = new AbstractDbRow(DbRowType.DBTYPE_USER);
        assertNotNull(abstractDbRow.newItem());
    }

    @Test
    void getKey() {
    }

    @Test
    void read() {
    }

    @Test
    void read1() {
    }

    @Test
    void readAndResolveAllLinks() {
    }

    @Test
    void readAndResolveAllLinks1() {
    }

    @Test
    void write() {
    }

    @Test
    void delete() {
    }

    @Test
    void newItem1() {
    }

    @Test
    void getValueByName() {
    }

    @Test
    void getValueByNameAsLong() {
    }

    @Test
    void getValueByNameAsInteger() {
    }

    @Test
    void getValueByNameAsShort() {
    }

    @Test
    void getValueByNameAsByte() {
    }

    @Test
    void getValueByNameAsCharacter() {
    }

    @Test
    void getValueByNameAsDouble() {
    }

    @Test
    void getValueByNameAsFloat() {
    }

    @Test
    void getValueByNameAsString() {
    }

    @Test
    void getValueByNameAsBoolean() {
    }

    @Test
    void getValueByIndex() {
    }

    @Test
    void getValueByIndexAsLong() {
    }

    @Test
    void getValueByIndexAsInteger() {
    }

    @Test
    void getValueByIndexAsShort() {
    }

    @Test
    void getValueByIndexAsByte() {
    }

    @Test
    void getValueByIndexAsCharacter() {
    }

    @Test
    void getValueByIndexAsString() {
    }

    @Test
    void getValueByIndexAsDouble() {
    }

    @Test
    void getValueByIndexAsFloat() {
    }

    @Test
    void getValueByIndexAsBoolean() {
    }

    @Test
    void setValueByName() {
    }

    @Test
    void setValueByName1() {
    }

    @Test
    void setValueByName2() {
    }

    @Test
    void setValueByName3() {
    }

    @Test
    void setValueByName4() {
    }

    @Test
    void setValueByName5() {
    }

    @Test
    void setValueByName6() {
    }

    @Test
    void setValueByName7() {
    }

    @Test
    void setValueByName8() {
    }

    @Test
    void setValueByName9() {
    }

    @Test
    void setValueByIndex() {
    }

    @Test
    void setValueByIndex1() {
    }

    @Test
    void setValueByIndex2() {
    }

    @Test
    void setValueByIndex3() {
    }

    @Test
    void setValueByIndex4() {
    }

    @Test
    void setValueByIndex5() {
    }

    @Test
    void setValueByIndex6() {
    }

    @Test
    void setValueByIndex7() {
    }

    @Test
    void setValueByIndex8() {
    }

    @Test
    void setValueByIndex9() {
    }

    @Test
    void readLinkByName() {
    }

    @Test
    void resolveLinkByFieldName() {
    }

    @Test
    void resolveLinkByFieldIndex() {
    }

    @Test
    void resolveLinkByLinkIndex() {
    }

    @Test
    void resolveAllLinks() {
    }

    @Test
    void updateLinkByFieldName() {
    }

    @Test
    void updateAllLinks() {
    }

    @Test
    void modified() {
    }
}