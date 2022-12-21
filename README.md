# RandomizeEncryption
Maximum randomized encryption

**Example:**
```Java
RandomizeEncryption encryption = new RandomizeEncryption();
CharSequence encrypt = encryption.encrypt("Hello");
CharSequence decrypt = encryption.decrypt();
System.out.println("Encrypt:" + encrypt + "\nDecrypt:" + decrypt);
Map<Integer, Character> constText = new HashMap<>();
constText.put(2, 't');
constText.put(9, 'e');
RandomizeEncryption e = new RandomizeEncryption(constText);
System.out.println("Map encrypt:" + e.mapEncrypt("eeteettteeee") + " Map decrypt"
+ e.mapDecrypt(e.mapEncrypt("eeetttteettttt")));
```
