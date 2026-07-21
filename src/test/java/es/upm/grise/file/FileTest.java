package es.upm.grise.file;

import org.junit.jupiter.api.Test;

class CruiseControlTest {

	@Test
	public void smokeTest() {}
	
}
@Test
public void testAddPropertyCorrect() throws Exception {
    File file = new File(FileType.PROPERTY, new Location("test"));
    file.addProperty("name=Maria".toCharArray());
    assertTrue(file.getContent().size() > 0);
}

@Test(expected = InvalidContentException.class)
public void testAddPropertyNull() throws Exception {
    File file = new File(FileType.PROPERTY, new Location("test"));
    file.addProperty(null);
}

@Test(expected = WrongFileTypeException.class)
public void testAddPropertyWrongType() throws Exception {
    File file = new File(FileType.IMAGE, new Location("test"));
    file.addProperty("key=value".toCharArray());
}

@Test
public void testAddImageBytesCorrect() throws Exception {
    File file = new File(FileType.IMAGE, new Location("test"));
    file.addImageBytes(new char[]{10, 20, 30});
    assertEquals(3, file.getContent().size());
}

@Test(expected = WrongEncodingException.class)
public void testAddImageBytesWrongEncoding() throws Exception {
    File file = new File(FileType.IMAGE, new Location("test"));
    file.addImageBytes(new char[]{300});
}

@Test
public void testRemoveContent() {
    File file = new File(FileType.PROPERTY, new Location("test"));
    file.getContent().add('a');
    file.getContent().add('b');

    file.removeContent(1);

    assertEquals(1, file.getContent().size());
}