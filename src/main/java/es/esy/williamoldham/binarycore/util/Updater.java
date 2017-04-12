package es.esy.williamoldham.binarycore.util;

import es.esy.williamoldham.binarycore.BinaryPlugin;
import es.esy.williamoldham.binarycore.PluginLoader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * Created by william on 12/04/17.
 */
public class Updater {

    public static boolean updateAll() {
        try {
            for (BinaryPlugin plugin : PluginLoader.getInstance().getPlugins()) {
                getLatestRelease(plugin);
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public static void getLatestRelease(BinaryPlugin plugin) throws IOException, ParseException {
        String repoName = plugin.getRepoName();
        File updateDir = new File(plugin.getDataFolder(), "/updates");
        updateDir.mkdirs();
        JSONObject json = readJsonFromUrl("https://api.github.com/repos/binaryoverload/" + repoName + "/releases/latest");
        if (json == null || json.isEmpty()) {
            throw new InvalidObjectException("Repository cannot be reached! Contact the author!");
        } else {
            String tag = (String) json.get("tag_name");
            if (!(tag.equalsIgnoreCase(plugin.getDescription().getVersion()))) {
                JSONArray assets = (JSONArray) json.get("assets");
                String download = (String) ((JSONObject) (assets.get(0))).get("browser_download_url");
                String fileName = download.split("/")[download.split("/").length-1];
                URL downloadUrl = new URL(download);
                try (InputStream in = downloadUrl.openStream()) {
                    Files.copy(in, updateDir.toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
                Files.copy(new File(updateDir, fileName).toPath(), plugin.getDataFolder().toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, ParseException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

}
