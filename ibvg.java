// ====== إضافات مطلوبة (لا تحذف شي من فوق) ======

// 1) زر "تواصل معنا" يودّي لانستا pandastudio.tech
(function(){
  const instaUrl = "https://www.instagram.com/pandastudio.tech/";
  const allButtons = document.querySelectorAll("button");

  allButtons.forEach(btn => {
    const t = (btn.textContent || "").trim();
    if (t === "تواصل معنا") {
      btn.addEventListener("click", (e) => {
        e.preventDefault();
        window.open(instaUrl, "_blank", "noopener,noreferrer");
      });
    }
  });
})();

// 2) إضافة زر تحميل الأداة (PandaTweak.zip) بدون تعديل الـ HTML
(function(){
  const zipName = "PandaTweak.zip"; // لازم يكون بنفس مجلد index.html
  const toolInfo = document.querySelector(".toolInfo");
  if (!toolInfo) return;

  // مكان الأزرار الحالي
  const actionsRow = toolInfo.querySelector("div[style*='margin-top:14px']");
  if (!actionsRow) return;

  // إنشاء رابط تحميل بشكل زر
  const downloadLink = document.createElement("a");
  downloadLink.href = zipName;
  downloadLink.setAttribute("download", "");
  downloadLink.className = "btn";
  downloadLink.textContent = "تحميل الأداة";
  downloadLink.style.textDecoration = "none";
  downloadLink.style.display = "inline-flex";
  downloadLink.style.alignItems = "center";
  downloadLink.style.justifyContent = "center";

  // نضيفه كزر ثالث
  actionsRow.appendChild(downloadLink);
})();

// 3) تكبير صورة الأداة عند الضغط عليها (تفاعل لطيف)
(function(){
  const img = document.querySelector(".toolMedia img");
  if(!img) return;

  img.style.cursor = "zoom-in";

  img.addEventListener("click", () => {
    const overlay = document.createElement("div");
    overlay.style.position = "fixed";
    overlay.style.inset = "0";
    overlay.style.zIndex = "200";
    overlay.style.background = "rgba(0,0,0,.72)";
    overlay.style.backdropFilter = "blur(12px)";
    overlay.style.display = "grid";
    overlay.style.placeItems = "center";
    overlay.style.padding = "16px";

    const box = document.createElement("div");
    box.style.maxWidth = "980px";
    box.style.width = "100%";
    box.style.borderRadius = "22px";
    box.style.overflow = "hidden";
    box.style.border = "1px solid rgba(255,255,255,.14)";
    box.style.background = "rgba(0,0,0,.35)";
    box.style.boxShadow = "0 26px 90px rgba(0,0,0,.65)";

    const big = document.createElement("img");
    big.src = img.src;
    big.alt = img.alt || "معاينة";
    big.style.width = "100%";
    big.style.height = "auto";
    big.style.display = "block";

    const hint = document.createElement("div");
    hint.textContent = "اضغط أي مكان للإغلاق";
    hint.style.padding = "12px 14px";
    hint.style.color = "rgba(234,242,255,.8)";
    hint.style.fontSize = "12.5px";
    hint.style.borderTop = "1px solid rgba(255,255,255,.10)";
    hint.style.background = "rgba(0,0,0,.25)";

    box.appendChild(big);
    box.appendChild(hint);
    overlay.appendChild(box);

    overlay.addEventListener("click", () => overlay.remove());
    document.body.appendChild(overlay);
  });
})();
