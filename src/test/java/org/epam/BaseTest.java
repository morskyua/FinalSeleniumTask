package org.epam;

import org.epam.util.PropertyReader;

public abstract class BaseTest {
    protected final PropertyReader propertyReader = PropertyReader.getPropertyReader("src/test/resources/prod.properties");
}
