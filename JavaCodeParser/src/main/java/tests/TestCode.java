package tests;

public class TestCode {
    public static String testCode0(){
        String text = "public class MyClass{"
                + "public static void main(String[] args){\n"
                + "System.out.println(\"Hello World\");"
                + "}"
                + "}";
        return text;
    }

    public static String testCode1(){
        String text =  //"public class MyClass{" +
                "public static void main(String[] args) {\n" +
                        "    Object pw = \"Password\";\n" +
                        "    System.out.println(\"String: \" + pw);\n" +
                        "\n" +
                        "    pw = \"Password\".toCharArray();\n" +
                        "    System.out.println(\"Array: \" + pw);\n" +
                        //"}" +
                        "}";
        return text;
    }

    public static String testCode2(){
        String text = "String strPwd = &quot;passwd&quot;;\n" +
                "char[] charPwd = new char[]{'p','a','s','s','w','d'};\n" +
                "System.out.println(&quot;String password: &quot; + strPwd );\n" +
                "System.out.println(&quot;Character password: &quot; + charPwd );";
        return text;
    }

    // Not a Java Code
    public static String testCode3(){
        String text = "String strPassword=&quot;Unknown&quot;;\n" +
                "char[] charPassword= new char[]{'U','n','k','w','o','n'};\n" +
                "System.out.println(&quot;String password: &quot; + strPassword);\n" +
                "System.out.println(&quot;Character password: &quot; + charPassword);\n" +
                "\n" +
                "String password: Unknown\n" +
                "Character password: [C@110b053";
        return text;
    }

    public static String testCode4(){
        return "public boolean equals(Object anObject) {\n" +
                "    if (this == anObject) {\n" +
                "        return true;\n" +
                "    }\n" +
                "    if (anObject instanceof String) {\n" +
                "        String anotherString = (String)anObject;\n" +
                "        int n = value.length;\n" +
                "        // Quits here if Strings are different lengths.\n" +
                "        if (n == anotherString.value.length) {\n" +
                "            char v1[] = value;\n" +
                "            char v2[] = anotherString.value;\n" +
                "            int i = 0;\n" +
                "            // Quits here at first different character.\n" +
                "            while (n-- != 0) {\n" +
                "                if (v1[i] != v2[i])\n" +
                "                    return false;\n" +
                "                i++;\n" +
                "            }\n" +
                "            return true;\n" +
                "        }\n" +
                "    }\n" +
                "    return false;\n" +
                "}";
    }

    public static String testCode5(){
        return "public static void main(String[] args) {\n" +
                "    System.out.println(&quot;please enter a password&quot;);\n" +
                "    // don't actually do this, this is an example only.\n" +
                "    Scanner in = new Scanner(System.in);\n" +
                "    String password = in.nextLine();\n" +
                "    usePassword(password);\n" +
                "\n" +
                "    clearString(password);\n" +
                "\n" +
                "    System.out.println(&quot;password: '&quot; + password + &quot;'&quot;);\n" +
                "}\n" +
                "\n" +
                "private static void usePassword(String password) {\n" +
                "\n" +
                "}\n" +
                "\n" +
                "private static void clearString(String password) {\n" +
                "    try {\n" +
                "        Field value = String.class.getDeclaredField(&quot;value&quot;);\n" +
                "        value.setAccessible(true);\n" +
                "        char[] chars = (char[]) value.get(password);\n" +
                "        Arrays.fill(chars, '*');\n" +
                "    } catch (Exception e) {\n" +
                "        throw new AssertionError(e);\n" +
                "    }\n" +
                "}";
    }

    // Not a Java Code: aid="50032305" qid="8881291"
    public static String testCode6(){
        return "char[] passw = request.getPassword().toCharArray()\n" +
                "if (comparePasswords(dbPassword, passw) {\n" +
                " allowUser = true;\n" +
                " cleanPassword(passw);\n" +
                " cleanPassword(dbPassword);\n" +
                " passw=null;\n" +
                "}\n" +
                "\n" +
                "private static void cleanPassword (char[] pass) {\n" +
                " for (char ch: pass) {\n" +
                "  ch = '0';\n" +
                " }\n" +
                "}";
    }

    // Sql Statement
    public static String testCode7(){
        return "select my_column from my_table where  instr(?, ','||search_column||',') &amp;gt; 0";
    }

    public static String testCode8(){
        return "ps.setString(1, &quot;,A,B,C,&quot;); ";
    }

    public static String testCode9(){
        return "public void myQuery(List&amp;lt;String&amp;gt; items, int other) {\n" +
                "  ...\n" +
                "  String q4in = generateQsForIn(items.size());\n" +
                "  String sql = &quot;select * from stuff where foo in ( &quot; + q4in + &quot; ) and bar = ?&quot;;\n" +
                "  PreparedStatement ps = connection.prepareStatement(sql);\n" +
                "  int i = 1;\n" +
                "  for (String item : items) {\n" +
                "    ps.setString(i++, item);\n" +
                "  }\n" +
                "  ps.setInt(i++, other);\n" +
                "  ResultSet rs = ps.executeQuery();\n" +
                "  ...\n" +
                "}\n" +
                "\n" +
                "private String generateQsForIn(int numQs) {\n" +
                "    String items = &quot;&quot;;\n" +
                "    for (int i = 0; i &amp;lt; numQs; i++) {\n" +
                "        if (i != 0) items += &quot;, &quot;;\n" +
                "        items += &quot;?&quot;;\n" +
                "    }\n" +
                "    return items;\n" +
                "}";
    }

    public static String testCode10(){
        return "create or replace type split_tbl as table of varchar(32767);\n" +
                "/\n" +
                "\n" +
                "create or replace function split\n" +
                "(\n" +
                "  p_list varchar2,\n" +
                "  p_del varchar2 := ','\n" +
                ") return split_tbl pipelined\n" +
                "is\n" +
                "  l_idx    pls_integer;\n" +
                "  l_list    varchar2(32767) := p_list;\n" +
                "  l_value    varchar2(32767);\n" +
                "begin\n" +
                "  loop\n" +
                "    l_idx := instr(l_list,p_del);\n" +
                "    if l_idx &amp;gt; 0 then\n" +
                "      pipe row(substr(l_list,1,l_idx-1));\n" +
                "      l_list := substr(l_list,l_idx+length(p_del));\n" +
                "    else\n" +
                "      pipe row(l_list);\n" +
                "      exit;\n" +
                "    end if;\n" +
                "  end loop;\n" +
                "  return;\n" +
                "end split;\n" +
                "/";
    }

    public static String testCode11(){
        return "final PreparedStatement statement = connection.prepareStatement(\n" +
                "        &quot;SELECT my_column FROM my_table where search_column = ANY (?)&quot;\n" +
                ");\n" +
                "final String[] values = getValues();\n" +
                "statement.setArray(1, connection.createArrayOf(&quot;text&quot;, values));\n" +
                "final ResultSet rs = statement.executeQuery();\n" +
                "try {\n" +
                "    while(rs.next()) {\n" +
                "        // do some...\n" +
                "    }\n" +
                "} finally {\n" +
                "    rs.close();\n" +
                "}";
    }

    public static String testCode12(){
        return "String param1 = &quot;X&quot;;\n" +
                "    String param2 = &quot;Y&quot;;\n" +
                "    String param1 = param1.append(&quot;,&quot;).append(param2);";
    }

    public static String testCode13() {
        return "/*usage:\n" +
                "\n" +
                "Util u = new Util(500); //500 items per bracket. \n" +
                "String sqlBefore  = &quot;select * from myTable where (&quot;;\n" +
                "List&amp;lt;Integer&amp;gt; values = new ArrayList&amp;lt;Integer&amp;gt;(Arrays.asList(1,2,4,5)); \n" +
                "string sqlAfter = &quot;) and foo = 'bar'&quot;; \n" +
                "\n" +
                "PreparedStatement ps = u.prepareStatements(sqlBefore, values, sqlAfter, connection, &quot;someId&quot;);\n" +
                "*/\n" +
                "\n" +
                "\n" +
                "\n" +
                "import java.sql.Connection;\n" +
                "import java.sql.PreparedStatement;\n" +
                "import java.sql.SQLException;\n" +
                "import java.util.ArrayList;\n" +
                "import java.util.List;\n" +
                "\n" +
                "public class Util {\n" +
                "\n" +
                "    private int numValuesInClause;\n" +
                "\n" +
                "    public Util(int numValuesInClause) {\n" +
                "        super();\n" +
                "        this.numValuesInClause = numValuesInClause;\n" +
                "    }\n" +
                "\n" +
                "    public int getNumValuesInClause() {\n" +
                "        return numValuesInClause;\n" +
                "    }\n" +
                "\n" +
                "    public void setNumValuesInClause(int numValuesInClause) {\n" +
                "        this.numValuesInClause = numValuesInClause;\n" +
                "    }\n" +
                "\n" +
                "    /** Split a given list into a list of lists for the given size of numValuesInClause*/\n" +
                "    public List&amp;lt;List&amp;lt;Integer&amp;gt;&amp;gt; splitList(\n" +
                "            List&amp;lt;Integer&amp;gt; values) {\n" +
                "\n" +
                "\n" +
                "        List&amp;lt;List&amp;lt;Integer&amp;gt;&amp;gt; newList = new ArrayList&amp;lt;List&amp;lt;Integer&amp;gt;&amp;gt;(); \n" +
                "        while (values.size() &amp;gt; numValuesInClause) {\n" +
                "            List&amp;lt;Integer&amp;gt; sublist = values.subList(0,numValuesInClause);\n" +
                "            List&amp;lt;Integer&amp;gt; values2 = values.subList(numValuesInClause, values.size());   \n" +
                "            values = values2; \n" +
                "\n" +
                "            newList.add( sublist);\n" +
                "        }\n" +
                "        newList.add(values);\n" +
                "\n" +
                "        return newList;\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * Generates a series of split out in clause statements. \n" +
                "     * @param sqlBefore &quot;&quot;select * from dual where (&quot;\n" +
                "     * @param values [1,2,3,4,5,6,7,8,9,10]\n" +
                "     * @param &quot;sqlAfter ) and id = 5&quot;\n" +
                "     * @return &quot;select * from dual where (id in (1,2,3) or id in (4,5,6) or id in (7,8,9) or id in (10)&quot;\n" +
                "     */\n" +
                "    public String genInClauseSql(String sqlBefore, List&amp;lt;Integer&amp;gt; values,\n" +
                "            String sqlAfter, String identifier) \n" +
                "    {\n" +
                "        List&amp;lt;List&amp;lt;Integer&amp;gt;&amp;gt; newLists = splitList(values);\n" +
                "        String stmt = sqlBefore;\n" +
                "\n" +
                "        /* now generate the in clause for each list */\n" +
                "        int j = 0; /* keep track of list:newLists index */\n" +
                "        for (List&amp;lt;Integer&amp;gt; list : newLists) {\n" +
                "            stmt = stmt + identifier +&quot; in (&quot;;\n" +
                "            StringBuilder innerBuilder = new StringBuilder();\n" +
                "\n" +
                "            for (int i = 0; i &amp;lt; list.size(); i++) {\n" +
                "                innerBuilder.append(&quot;?,&quot;);\n" +
                "            }\n" +
                "\n" +
                "\n" +
                "\n" +
                "            String inClause = innerBuilder.deleteCharAt(\n" +
                "                    innerBuilder.length() - 1).toString();\n" +
                "\n" +
                "            stmt = stmt + inClause;\n" +
                "            stmt = stmt + &quot;)&quot;;\n" +
                "\n" +
                "\n" +
                "            if (++j &amp;lt; newLists.size()) {\n" +
                "                stmt = stmt + &quot; OR &quot;;\n" +
                "            }\n" +
                "\n" +
                "        }\n" +
                "\n" +
                "        stmt = stmt + sqlAfter;\n" +
                "        return stmt;\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * Method to convert your SQL and a list of ID into a safe prepared\n" +
                "     * statements\n" +
                "     * \n" +
                "     * @throws SQLException\n" +
                "     */\n" +
                "    public PreparedStatement prepareStatements(String sqlBefore,\n" +
                "            ArrayList&amp;lt;Integer&amp;gt; values, String sqlAfter, Connection c, String identifier)\n" +
                "            throws SQLException {\n" +
                "\n" +
                "        /* First split our potentially big list into lots of lists */\n" +
                "        String stmt = genInClauseSql(sqlBefore, values, sqlAfter, identifier);\n" +
                "        PreparedStatement ps = c.prepareStatement(stmt);\n" +
                "\n" +
                "        int i = 1;\n" +
                "        for (int val : values)\n" +
                "        {\n" +
                "\n" +
                "            ps.setInt(i++, val);\n" +
                "\n" +
                "        }\n" +
                "        return ps;\n" +
                "\n" +
                "    }\n" +
                "\n" +
                "}";
    }

    public static String testCode14(){
        return "String inParenthesis = \"(?\";\n" +
                "    for(int i = 1;i < myList.size();i++) {\n" +
                "      inParenthesis += \", ?\";\n" +
                "    }\n" +
                "    inParenthesis += \")\";\n" +
                "\n" +
                "    try(PreparedStatement statement = SQLite.connection.prepareStatement(\n" +
                "        String.format(\"UPDATE table SET value='WINNER' WHERE startTime=? AND name=? AND traderIdx=? AND someValue IN %s\", inParenthesis))) {\n" +
                "      int x = 1;\n" +
                "      statement.setLong(x++, race.startTime);\n" +
                "      statement.setString(x++, race.name);\n" +
                "      statement.setInt(x++, traderIdx);\n" +
                "\n" +
                "      for(String str : race.betFair.winners) {\n" +
                "        statement.setString(x++, str);\n" +
                "      }\n" +
                "\n" +
                "      int effected = statement.executeUpdate();\n" +
                "    }\n";
    }

    public static String testCode15(){
        return "// load the keystore, supplying the store password\n" +
                "KeyStore jks = KeyStore.getInstance(\"JKS\");\n" +
                "jks.load(new FileInputStream(jksFile), jksPass);\n" +
                "\n" +
                "// get the 'entry'\n" +
                "KeyStore.ProtectionParameter protParam = new KeyStore.PasswordProtection(password);\n" +
                "KeyStore.PrivateKeyEntry pkEntry = (KeyStore.PrivateKeyEntry)\n" +
                "    ks.getEntry(\"foo\", protParam);\n" +
                "\n" +
                "// grab the bits from the private key\n" +
                "PrivateKey myPrivateKey = pkEntry.getPrivateKey();\n";
    }

    public static String testCode16(){
        return "import sun.misc.BASE64Decoder;\n" +
                "import sun.misc.BASE64Encoder;\n" +
                "\n" +
                "import javax.crypto.*;\n" +
                "import javax.crypto.spec.SecretKeySpec;\n" +
                "import java.io.IOException;\n" +
                "import java.security.*;\n" +
                "\n" +
                "public class AESSecurityCap {\n" +
                "\n" +
                "private PublicKey publickey;\n" +
                "KeyAgreement keyAgreement;\n" +
                "byte[] sharedsecret;\n" +
                "\n" +
                "String ALGO = \"AES\";\n" +
                "\n" +
                "AESSecurityCap() {\n" +
                "    makeKeyExchangeParams();\n" +
                "}\n" +
                "\n" +
                "private void makeKeyExchangeParams() {\n" +
                "    KeyPairGenerator kpg = null;\n" +
                "    try {\n" +
                "        kpg = KeyPairGenerator.getInstance(\"EC\");\n" +
                "        kpg.initialize(128);\n" +
                "        KeyPair kp = kpg.generateKeyPair();\n" +
                "        publickey = kp.getPublic();\n" +
                "        keyAgreement = KeyAgreement.getInstance(\"ECDH\");\n" +
                "        keyAgreement.init(kp.getPrivate());\n" +
                "\n" +
                "    } catch (NoSuchAlgorithmException | InvalidKeyException e) {\n" +
                "        e.printStackTrace();\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "public void setReceiverPublicKey(PublicKey publickey) {\n" +
                "    try {\n" +
                "        keyAgreement.doPhase(publickey, true);\n" +
                "        sharedsecret = keyAgreement.generateSecret();\n" +
                "    } catch (InvalidKeyException e) {\n" +
                "        e.printStackTrace();\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "public String encrypt(String msg) {\n" +
                "    try {\n" +
                "        Key key = generateKey();\n" +
                "        Cipher c = Cipher.getInstance(ALGO);\n" +
                "        c.init(Cipher.ENCRYPT_MODE, key);\n" +
                "        byte[] encVal = c.doFinal(msg.getBytes());\n" +
                "        return new BASE64Encoder().encode(encVal);\n" +
                "    } catch (BadPaddingException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException e) {\n" +
                "        e.printStackTrace();\n" +
                "    }\n" +
                "    return msg;\n" +
                "}\n" +
                "\n" +
                "public String decrypt(String encryptedData) {\n" +
                "    try {\n" +
                "        Key key = generateKey();\n" +
                "        Cipher c = Cipher.getInstance(ALGO);\n" +
                "        c.init(Cipher.DECRYPT_MODE, key);\n" +
                "        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);\n" +
                "        byte[] decValue = c.doFinal(decordedValue);\n" +
                "        return new String(decValue);\n" +
                "    } catch (BadPaddingException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException | IOException e) {\n" +
                "        e.printStackTrace();\n" +
                "    }\n" +
                "    return encryptedData;\n" +
                "}\n" +
                "\n" +
                "public PublicKey getPublickey() {\n" +
                "    return publickey;\n" +
                "}\n" +
                "\n" +
                "protected Key generateKey() {\n" +
                "    return new SecretKeySpec(sharedsecret, ALGO);\n" +
                "}\n" +
                "}\n";
    }

    public static String testCode17(){
        return "KeyStore.PrivateKeyEntry priEntry = \n" +
                "    new KeyStore.PrivateKeyEntry(keys.getPrivate(), certificateArray); \n" +
                "KeyStore.PasswordProtection password = \n" +
                "    new KeyStore.PasswordProtection(pass.toCharArray()); \n" +
                "store.setEntry(&quot;Entry&quot;, priEntry, password);";
    }
}
