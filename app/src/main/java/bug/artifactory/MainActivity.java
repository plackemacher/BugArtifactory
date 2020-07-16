package bug.artifactory;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.core.Core;
import com.core.CoreEvents;
import com.core.CoreEvents.Event;
import com.core.CoreEvents.Updatable;
import com.core.foo.FooService;
import com.core.muu.MuuService;

public class MainActivity extends AppCompatActivity {

    TextView foo, muu, bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foo = (TextView) findViewById(R.id.foo);
        muu = (TextView) findViewById(R.id.muu);
        bar = (TextView) findViewById(R.id.bar);

        CoreEvents.addObserver(updatable);
        Core.initCore(this, "core-name");
    }

    private final CoreEvents.Updatable updatable = new Updatable() {
        @Override
        public void onEvent(Event event) {
            String s = Core.getDefaultInstance().getCoreName();
            Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();

            foo.setText(FooService.getFooedName(Core.getDefaultInstance(), "Foo Place"));
            muu.setText(MuuService.getMuuName(Core.getDefaultInstance(), "Muu Place"));
            bar.setText(Core.getDefaultInstance().getUniqueWord());
        }
    };
}
