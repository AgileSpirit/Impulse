package infra.bootstrap;

import com.google.common.collect.Lists;
import domain.Bookmark;
import infra.mailing.MailService;
import infra.repository.BookmarkRepository;
import infra.util.DataGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Named
@Profile("localhost")
public class LocalhostBootstrap extends ApplicationBootstrap {

    @Inject
    private DataGenerator dataGenerator;

    @Inject
    private MailService mailService;

    @Inject
    private BookmarkRepository bookmarkRepository;

    @Value("${mail.message.to}")
    private String mailTo;

    @Override
    void bootstrap() {
        dataGenerator.populateData();
        dataGenerator.retrieveAndDisplayAllData();
        sendTestMail();
    }

    private void sendTestMail() {
        // Retrieve bookmarks
        final List<Bookmark> bookmarks = Lists.newArrayList(bookmarkRepository.findAll());

        // Prepare mail content data model
        final Map<String, Object> model = new HashMap<String, Object>();
        model.put("bookmarks", bookmarks);

        // Send mail
        mailService.sendMail("JavaBackbone test", mailTo, "sendBookmarks.vm", model);
    }

}
