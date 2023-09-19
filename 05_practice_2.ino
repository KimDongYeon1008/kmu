#define PIN_LED 7
unsigned int toggle;

void setup() { 
  pinMode(PIN_LED, OUTPUT);
  toggle = 0;

  digitalWrite(PIN_LED, toggle);
  delay(1000);

  for (int i = 0; i < 11; i++) {
    toggle = toggle_state(toggle);
    digitalWrite(PIN_LED, toggle);
    delay(200);
  }

  while (1) {}
}

void loop() {
}

int toggle_state(int toggle) {
  return !toggle;
}
